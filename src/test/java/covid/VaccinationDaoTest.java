package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VaccinationDaoTest {

    private VaccinationDao vaccinationDao;
    private MariaDbDataSource dataSource;

    @BeforeEach
    void init() throws SQLException {
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("covid");
        dataSource.setPassword("covid");

        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();

        vaccinationDao = new VaccinationDao(dataSource);

    }

    @Test
    void testVaccinationSuccess() {
        CitizensDao citizensDao = new CitizensDao(dataSource);
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizenDB = citizensDao.saveCitizen(citizen);
        Vaccination vaccination = Vaccination.vaccinationSuccess(citizenDB.getId(), LocalDateTime.now(),VaccinationType.PFIZER_BIOTECH);
        Vaccination vaccinationDB = vaccinationDao.vaccinationDaoSuccess(vaccination);

        assertEquals(1L, vaccinationDB.getId());
        assertEquals(VaccinationType.PFIZER_BIOTECH, vaccinationDB.getVaccinationType());
    }

    @Test
    void testSelectByCitizenId() {
        CitizensDao citizensDao = new CitizensDao(dataSource);
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizenDB = citizensDao.saveCitizen(citizen);
        Vaccination vaccination = Vaccination.vaccinationSuccess(citizenDB.getId(), LocalDateTime.now(),VaccinationType.PFIZER_BIOTECH);
        Vaccination vaccinationDB = vaccinationDao.vaccinationDaoSuccess(vaccination);
        assertEquals(VaccinationType.PFIZER_BIOTECH, vaccinationDB.getVaccinationType());
    }

}