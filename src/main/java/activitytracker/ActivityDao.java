package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    void saveActivity(Activity activity) {
        String sql = "insert into `activities`(`activity_starttime`,`activity_desc`,`activity_type`) values (?,?,?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(sql);
        ) {
            ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            ps.setString(2, activity.getDesc());
            ps.setString(3, activity.getType().toString());
            ps.executeUpdate();
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }
    Activity findActivityById(long id) {
        String sql = "SELECT * FROM `activities` WHERE `activity_id` = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql);
        ) {
            ps.setLong(1, id);
            if (getActivityFromResultSet(ps).size()==1){
                return getActivityFromResultSet(ps).get(0);
            }
            throw new IllegalStateException("Not Found");
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }
    List<Activity> listActivities() {
        String sql = "SELECT * FROM `activities` ORDER BY `activity_id`";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

        ) {
            return getActivityFromResultSet(ps);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<Activity> listActivityByType(ActivityType type) {
        String sql = "SELECT * FROM `activities` where `activity_type` = ?";
        try (Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1,type.toString());
            if (getActivityFromResultSet(ps).size()==0) {
                throw new IllegalStateException("List is empty");
            }
            return getActivityFromResultSet(ps);
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }
    }

    private List<Activity> getActivityFromResultSet(PreparedStatement ps) {
        List<Activity> result = new ArrayList<>();
        try (
                ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                long activityId = rs.getLong(1);
                LocalDateTime starttime = rs.getTimestamp(2).toLocalDateTime();
                String desc = rs.getString(3);
                ActivityType type = ActivityType.valueOf(rs.getString(4));
                result.add(new Activity(activityId, starttime, desc, type));
            }
            return result;
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }

    }


}
