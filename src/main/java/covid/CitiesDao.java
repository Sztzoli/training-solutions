package covid;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitiesDao {

    private final DataSource dataSource;

    public CitiesDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<String> selectCityByZip(String zip) {
        String sql = "SELECT `city` FROM `cities` WHERE `zip` = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, zip);
            return selectCityByPreparedStatement(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by select", sqle);
        }
    }



    private List<String> selectCityByPreparedStatement(PreparedStatement ps) {
        List<String> result = new ArrayList<>();
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String city = rs.getString("city");
                result.add(city);
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot query", sqle);
        }
    }

    public List<String> listCityByZip(String zip) {
        CitiesDao citiesDao = new CitiesDao(dataSource);
        return citiesDao.selectCityByZip(zip);
    }


}
