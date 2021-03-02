package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {

    private final DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity) {
        String sql = "insert into `activities`(`activity_starttime`,`activity_desc`,`activity_type`) values (?,?,?)";
        try (Connection conn = dataSource.getConnection()

        ) {
            long id;
            try (PreparedStatement ps =
                         conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                ps.setString(2, activity.getDesc());
                ps.setString(3, activity.getType().toString());
                ps.executeUpdate();
                id = executeAndGetGeneratedKey(ps);
            }

            conn.setAutoCommit(false);
            try (PreparedStatement preparedStatement = conn.prepareStatement("insert into track_points (activity_id, track_time, lat, lon) values (?,?,?,?)")) {
                for (TrackPoint trackPoint : activity.getTrackPoints()) {
                    trackPoint.checkTrackPoint();
                    preparedStatement.setLong(1, id);
                    preparedStatement.setDate(2, Date.valueOf(trackPoint.getTime()));
                    preparedStatement.setInt(3, trackPoint.getLat());
                    preparedStatement.setInt(4, trackPoint.getLon());
                    preparedStatement.executeUpdate();
                }
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new IllegalArgumentException("something went wrong", e);
            }
            return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error by insert", sqle);
        }
    }

    public List<Activity> insertActivities(List<Activity> activities) {
        String sql = "insert into `activities`(`activity_starttime`,`activity_desc`,`activity_type`) values (?,?,?)";
        List<Activity> result = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
        ) {
            conn.setAutoCommit(false);
            try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                for (Activity activity : activities) {
                    ps.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
                    ps.setString(2, activity.getDesc());
                    ps.setString(3, activity.getType().toString());
                    ps.executeUpdate();
                    long id = executeAndGetGeneratedKey(ps);
                    result.add(new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType()));
                }
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new IllegalStateException("Something went wrong", e);
            }


        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by insert", sqle);
        }
        return result;
    }

    private long executeAndGetGeneratedKey(PreparedStatement ps) {
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                throw new SQLException("No key was generated");
            }
        } catch (SQLException throwables) {
            throw new IllegalStateException("Error by insert");
        }
    }

    public Activity findActivityById(long id) {
        String sql = "SELECT * FROM `activities` WHERE `activity_id` = ?";
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps =
                        conn.prepareStatement(sql)
        ) {
            ps.setLong(1, id);
            if (getActivityFromResultSet(ps).size() == 1) {
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
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, type.toString());
            if (getActivityFromResultSet(ps).isEmpty()) {
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
