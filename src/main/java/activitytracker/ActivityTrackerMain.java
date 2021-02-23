package activitytracker;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public List<Activity> listActivity(MariaDbDataSource dataSource) {
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

    public void insertActivity(MariaDbDataSource dataSource, Activity activity) {
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

    public Activity selectActivityById(MariaDbDataSource dataSource, Long id) {
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

    public static void main(String[] args) {
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
            dataSource.setUser("activitytracker");
            dataSource.setPassword("activitytracker");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }

        Activity activity1 = new Activity(LocalDateTime.now(), "Kékesttető", ActivityType.HIKING);
        Activity activity2 = new Activity(LocalDateTime.now(), "Budapest", ActivityType.BIKING);
        Activity activity3 = new Activity(LocalDateTime.now(), "Kecskemét", ActivityType.RUNNING);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        ActivityDao activityDao = new ActivityDao(dataSource);
        activityDao.saveActivity(activity1);
        activityDao.saveActivity(activity2);
        activityDao.saveActivity(activity3);
        System.out.println(activityDao.findActivityById(1L));
        System.out.println(activityDao.listActivities());
        System.out.println(activityDao.listActivityByType(ActivityType.BIKING));




    }
}
