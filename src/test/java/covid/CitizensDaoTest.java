package covid;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CitizensDaoTest {

    private CitizensDao citizensDao;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
        dataSource.setUser("covid");
        dataSource.setPassword("covid");

        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();

        citizensDao = new CitizensDao(dataSource);

    }

    @Test
    void testSaveCitizen() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizenFromDB = citizensDao.saveCitizen(citizen);
        assertEquals(1L, citizenFromDB.getId());
    }

    @Test
    void testSaveListOfCitizen() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen1 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen2 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen3 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        List<Citizen> citizens = List.of(citizen, citizen1, citizen2, citizen3);

        List<Citizen> citizensDB = citizensDao.saveListOfCitizen(citizens);
        assertEquals(4, citizensDB.size());
    }

    @Test
    void testSelectByZip() {
        Citizen citizen = new Citizen("ZJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen1 = new Citizen("CJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen2 = new Citizen("AJohn Doe", "2000", 100, "vlalami@mail.com", "111111110");
        Citizen citizen3 = new Citizen("HJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen4 = new Citizen("JJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen5 = new Citizen("PJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen6 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen7 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen8 = new Citizen("AJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen9 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen10 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen11 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen12 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen13 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen14 = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen15 = new Citizen("ZJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen16 = new Citizen("ZJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen17 = new Citizen("ZJohn Doe", "2000", 30, "vlalami@mail.com", "111111110");
        List<Citizen> citizens =
                List.of(citizen, citizen1, citizen2, citizen3, citizen4, citizen5,
                        citizen6, citizen7, citizen8, citizen9, citizen10, citizen11,
                        citizen12, citizen13, citizen14, citizen15, citizen16, citizen17);
        citizensDao.saveListOfCitizen(citizens);
        List<Citizen> citizensByZip = citizensDao.selectByZip("2000");

        assertEquals(16, citizensByZip.size());
        assertEquals("AJohn Doe", citizensByZip.get(0).getName());
    }

    @Test
    void testSelectByTaj() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen1 = new Citizen("Jack Doe", "2000", 30, "vlalami@mail.com", "222222220");
        Citizen citizen2 = new Citizen("Jane Doe", "2000", 30, "vlalami@mail.com", "333333330");
        Citizen citizen3 = new Citizen("John Smith", "2000", 30, "vlalami@mail.com", "444444440");
        List<Citizen> citizens = List.of(citizen, citizen1, citizen2, citizen3);
        citizensDao.saveListOfCitizen(citizens);

        Citizen citizenDB = citizensDao.selectByTaj("222222220");
        assertEquals("Jack Doe", citizenDB.getName());
    }

    @Test
    void testUpdateNumberOfVaccination() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizenDB = citizensDao.saveCitizen(citizen);
        assertEquals(0, citizenDB.getNumberOfVaccination());
        citizenDB.addVaccination();
        citizensDao.updateNumberOfVaccination(citizenDB);
        assertEquals(1, citizensDao.selectByTaj(citizenDB.getTaj()).getNumberOfVaccination());
        citizenDB.addVaccination();
        citizensDao.updateNumberOfVaccination(citizenDB);
        assertEquals(2, citizensDao.selectByTaj(citizenDB.getTaj()).getNumberOfVaccination());
    }

    @Test
    void testUpdateDateOfVaccination() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizenDB = citizensDao.saveCitizen(citizen);
        assertEquals(null, citizenDB.getLastVaccinationDate());
        citizenDB.setLastVaccinationDate(LocalDateTime.of(2012,12,12,12,12));
        citizensDao.updateDateOfVaccination(citizenDB);
        assertEquals(LocalDateTime.of(2012,12,12,12,12), citizensDao.selectByTaj(citizenDB.getTaj()).getLastVaccinationDate());
    }

    @Test
    void Riport() {
        Citizen citizen = new Citizen("John Doe", "2000", 30, "vlalami@mail.com", "111111110");
        Citizen citizen1 = new Citizen("Jack Doe", "2000", 30, "vlalami@mail.com", "222222220");
        Citizen citizen2 = new Citizen("Jane Doe", "2000", 30, "vlalami@mail.com", "333333330");
        Citizen citizen3 = new Citizen("John Smith", "2000", 30, "vlalami@mail.com", "444444440");
        Citizen citizen4 = new Citizen("John DoeDoe", "6000", 30, "vlalami@mail.com", "555555550");
        Citizen citizen5 = new Citizen("Jack DoeDoe", "6000", 30, "vlalami@mail.com", "666666660");
        Citizen citizen6 = new Citizen("Jane DoeDoe", "6000", 30, "vlalami@mail.com", "777777770");
        Citizen citizen7 = new Citizen("John SmithSmith", "6000", 30, "vlalami@mail.com", "888888880");
        List<Citizen> citizens = List.of(citizen,citizen1,citizen2,citizen3,citizen4,citizen5,citizen6,citizen7);
        citizensDao.saveListOfCitizen(citizens);

        Citizen citizenDB = citizensDao.selectByTaj("111111110");
        citizenDB.addVaccination();
        citizenDB.addVaccination();
        citizensDao.updateNumberOfVaccination(citizenDB);
        Citizen citizenDB2 = citizensDao.selectByTaj("222222220");
        citizenDB2.addVaccination();
        citizensDao.updateNumberOfVaccination(citizenDB2);
        assertEquals(2, citizensDao.selectRiport().get(0).getZeroVaccination());
    }


}