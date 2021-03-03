package covid;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CitizensDao {

    private final DataSource dataSource;

    public CitizensDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Citizen saveCitizen(Citizen citizen) {
        String sql = "INSERT INTO `citizens` (`citizen_name`, `zip`, `age`, `email`, `taj`) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection()) {
            long id;
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, citizen.getName());
                ps.setString(2, citizen.getZip());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getTaj());
                ps.executeUpdate();
                id = executeAndGetGeneratedKey(ps);
            }
            return new Citizen(id, citizen.getName(), citizen.getZip(), citizen.getAge(), citizen.getEmail(), citizen.getTaj());
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by insert", sqle);
        }
    }

    public Citizen selectByTaj(String taj) {
        String sql = "SELECT `citizen_id`,`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`,`last_vaccination` FROM `citizens` WHERE `taj` = (?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, taj);
            if (!getCitizenFromResultSet(ps).isEmpty()) {
                return getCitizenFromResultSet(ps).get(0);
            } else {
                return null;
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by select", sqle);
        }
    }

    public List<Citizen> saveListOfCitizen(List<Citizen> citizens) {
        List<Citizen> result = new ArrayList<>();
        String sql = "INSERT INTO `citizens` (`citizen_name`, `zip`, `age`, `email`, `taj`) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection()) {
            conn.setAutoCommit(false);
            prepareStatementCommit(citizens, result, sql, conn);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by Insert", sqle);
        }
        return result;
    }


    public List<Citizen> selectByZip(String zip) {
        LocalDateTime dateTime = LocalDateTime.now();
        String sql = "SELECT `citizen_id`,`citizen_name`, `zip`, `age`, `email`, `taj`,`number_of_vaccination`,`last_vaccination` " +
                "FROM `citizens`" +
                " WHERE `zip` = ? AND (`number_of_vaccination`<2 OR `number_of_vaccination` IS NULL) AND (`last_vaccination` IS NULL OR last_vaccination<?) " +
                "ORDER BY `age` DESC, `citizen_name` " +
                "LIMIT 16";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, zip);
            ps.setTimestamp(2, Timestamp.valueOf(dateTime));
            return getCitizenFromResultSet(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by select", sqle);
        }
    }

    private List<Citizen> getCitizenFromResultSet(PreparedStatement ps) {
        List<Citizen> result = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                String zip = rs.getString(3);
                int age = rs.getInt(4);
                String email = rs.getString(5);
                String taj = rs.getString(6);
                int numberVaccination = rs.getInt(7);
                Timestamp timestamp = rs.getTimestamp(8);
                LocalDateTime lastVaccination = null;
                if (timestamp != null) {
                    lastVaccination = timestamp.toLocalDateTime();
                }
                result.add(new Citizen(id, name, zip, age, email, taj, numberVaccination, lastVaccination));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    private void prepareStatementCommit(List<Citizen> citizens, List<Citizen> result, String sql, Connection conn) throws SQLException {
        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            for (Citizen citizen : citizens) {
                ps.setString(1, citizen.getName());
                ps.setString(2, citizen.getZip());
                ps.setInt(3, citizen.getAge());
                ps.setString(4, citizen.getEmail());
                ps.setString(5, citizen.getTaj());
                ps.executeUpdate();
                long id = executeAndGetGeneratedKey(ps);
                result.add(new Citizen(id, citizen.getName(), citizen.getZip(), citizen.getAge(), citizen.getEmail(), citizen.getTaj()));
            }
            conn.commit();
        } catch (Exception e) {
            conn.rollback();
            throw new IllegalStateException("Something went wrong", e);
        }
    }


    private long executeAndGetGeneratedKey(PreparedStatement ps) {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key was generated");
            }
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by insert", sqle);
        }
    }

    public void updateNumberOfVaccination(Citizen citizen) {
        String sql = "UPDATE `citizens` SET `number_of_vaccination` = ? WHERE `citizen_id` = ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, citizen.getNumberOfVaccination());
            ps.setLong(2, citizen.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by update", sqle);
        }
    }

    public void updateDateOfVaccination(Citizen citizen) {
        String sql = "UPDATE `citizens` SET `last_vaccination` = ? WHERE `citizen_id` = ? ";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setTimestamp(1, Timestamp.valueOf(citizen.getLastVaccinationDate()));
            ps.setLong(2, citizen.getId());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by update", sqle);
        }
    }

    public List<Riport> selectRiport() {
        String sql = "SELECT `zip`, \n" +
                "  COUNT(Case WHEN `number_of_vaccination`=0 THEN 1 END) AS `zerovaccination`,\n" +
                "  COUNT(Case WHEN `number_of_vaccination`=1 THEN 1 END) AS `onevaccination`,\n" +
                "  COUNT(Case WHEN `number_of_vaccination`=2 THEN 1 END) AS `twovaccination`\n" +
                "FROM `citizens`\n" +
                "GROUP BY `zip`;";
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            List<Riport> result = new ArrayList<>();
            while (rs.next()) {
                String zip = rs.getString(1);
                int zero = rs.getInt(2);
                int one = rs.getInt(3);
                int two = rs.getInt(4);
                result.add(new Riport(zip, zero, one, two));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by select", sqle);
        }
    }
}
