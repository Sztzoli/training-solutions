package covid;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VaccinationDao {

    private final DataSource dataSource;

    public VaccinationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Vaccination vaccinationDaoSuccess(Vaccination vaccination) {
        String sql = "INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `status`, `vaccination_type`) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection()) {
            long id;
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setLong(1, vaccination.getCitizenId());
                ps.setTimestamp(2, Timestamp.valueOf(vaccination.getVaccinationDate()));
                ps.setString(3, vaccination.getStatus().toString());
                ps.setString(4, vaccination.getVaccinationType().toString());
                ps.executeUpdate();
                id = executeAndGetGeneratedKey(ps);
            }
            return new Vaccination(id, vaccination.getCitizenId(), vaccination.getVaccinationDate(), vaccination.getStatus(), null, vaccination.getVaccinationType());
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by insert", sqle);
        }
    }

    public Vaccination vaccinationDaoFail(Vaccination vaccination) {
        String sql = "INSERT INTO `vaccinations` (`citizen_id`, `vaccination_date`, `status`, `note`) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection()) {
            long id;
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setLong(1, vaccination.getCitizenId());
                ps.setTimestamp(2, Timestamp.valueOf(vaccination.getVaccinationDate()));
                ps.setString(3, vaccination.getStatus().toString());
                ps.setString(4, vaccination.getNote());
                ps.executeUpdate();
                id = executeAndGetGeneratedKey(ps);
            }
            return new Vaccination(id, vaccination.getCitizenId(), vaccination.getVaccinationDate(), vaccination.getStatus(), vaccination.getNote(), null);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by insert", sqle);
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

    public List<Vaccination> selectByCitizensId(long citizensId) {
        String sql = "SELECT `vaccination_id`, `citizen_id`, `vaccination_date`, `status`,`note`, `vaccination_type` FROM `vaccinations` WHERE `citizen_id` = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setLong(1, citizensId);
            if (getVaccinationCitizenFromResultSet(ps).isEmpty()) {
                throw new IllegalStateException("Not found");
            }
            return getVaccinationCitizenFromResultSet(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by select");
        }
    }

    private List<Vaccination> getVaccinationCitizenFromResultSet(PreparedStatement ps) {
        List<Vaccination> result = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                long vaccinationId = rs.getLong(1);
                long citizenId = rs.getLong(2);
                LocalDateTime vaccinationDate = rs.getTimestamp(3).toLocalDateTime();
                String status = rs.getString(4);
                String note = rs.getString(5);
                VaccinationType type = VaccinationType.valueOf(rs.getString(6));
                result.add(new Vaccination(vaccinationId, citizenId, vaccinationDate, VaccinationStatus.valueOf(status), note, type));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

}
