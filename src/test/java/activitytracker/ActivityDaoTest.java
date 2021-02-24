package activitytracker;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;


import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ActivityDaoTest {
    private ActivityDao activityDao;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/activitytracker?useUnicode=true");
        dataSource.setUser("activitytracker");
        dataSource.setPassword("activitytracker");

        activityDao = new ActivityDao(dataSource);

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();
        flyway.clean();
        flyway.migrate();

    }

    @Test
    void testSaveActivity() {
        Activity activity = new Activity(LocalDateTime.now(), "Kékestető", ActivityType.HIKING);
        Activity activityFromDS = activityDao.saveActivity(activity);
        assertEquals(1L,activityFromDS.getId());

    }

    @Test
    void testSaveActivity2() {
        Activity activity = new Activity(LocalDateTime.now(), "Kékestető", ActivityType.HIKING);
        Activity activity2 = new Activity(LocalDateTime.now(), "Kékestető", ActivityType.BIKING);

        System.out.println(activityDao.insertActivities(List.of(activity,activity2)));


    }


}