package covid;

import org.flywaydb.core.Flyway;
import org.mariadb.jdbc.MariaDbDataSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CovidService {

    MariaDbDataSource dataSource;
    private Scanner scanner = new Scanner(System.in);

    public CovidService() {
        dataSource = new MariaDbDataSource();
        try {
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Error by connection");
        }

        Flyway flyway = Flyway
                .configure()
                .dataSource(dataSource)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    public void vaccination() {

        VaccinationDao vaccinationDao = new VaccinationDao(dataSource);

        CitizensDao citizensDao = new CitizensDao(dataSource);
        System.out.println("Enter your TAJ number");
        String taj = scanner.nextLine();
        if (!(new CitizenDataCheck().checkTaj(taj)) || citizensDao.selectByTaj(taj) == null) {
            System.out.println("Wrong TAJ number");
            return;
        }
        Citizen citizen = citizensDao.selectByTaj(taj);
        int numberVaccination = citizen.getNumberOfVaccination();
        switch (numberVaccination) {
            case 0 -> {
                getFirstVaccination(vaccinationDao, citizensDao, citizen);
            }
            case 1 -> {
                getSecondVaccination(vaccinationDao, citizensDao, citizen);
            }
            case 2 -> {
                vaccinationAlreadyDone(vaccinationDao, citizen);
            }
        }

    }

    private void vaccinationAlreadyDone(VaccinationDao vaccinationDao, Citizen citizen) {
        List<Vaccination> vaccinations = vaccinationDao.selectByCitizensId(citizen.getId());
        System.out.println("You have already two vaccination");
        System.out.println("First: " + vaccinations.get(0).toString());
        System.out.println("Second: " + vaccinations.get(1).toString());
    }

    private void getSecondVaccination(VaccinationDao vaccinationDao, CitizensDao citizensDao, Citizen citizen) {
        Vaccination vaccinationDB = vaccinationDao.selectByCitizensId(citizen.getId()).get(0);
        System.out.println("Fist vaccination:\ntype: "
                + vaccinationDB.getVaccinationType() + "\nDate: " + vaccinationDB.getVaccinationDate());
        LocalDateTime time = getDateTimeFromUser();
        vaccinationDao.vaccinationDaoSuccess(Vaccination.vaccinationSuccess(citizen.getId(), time, vaccinationDB.getVaccinationType()));
        citizen.addVaccination();
        citizen.setLastVaccinationDate(time);
        citizensDao.updateNumberOfVaccination(citizen);
        citizensDao.updateDateOfVaccination(citizen);
    }


    private void getFirstVaccination(VaccinationDao vaccinationDao, CitizensDao citizensDao, Citizen citizen) {
        LocalDateTime time = getDateTimeFromUser();
        VaccinationType type = getVaccinationTypeFromUser();
        vaccinationDao.vaccinationDaoSuccess(Vaccination.vaccinationSuccess(citizen.getId(), time, type));
        updateCitizenWithVaccinationData(citizensDao, citizen, time);
    }

    private void updateCitizenWithVaccinationData(CitizensDao citizensDao, Citizen citizen, LocalDateTime time) {
        citizen.addVaccination();
        citizen.setLastVaccinationDate(time);
        citizensDao.updateNumberOfVaccination(citizen);
        citizensDao.updateDateOfVaccination(citizen);
    }

    private LocalDateTime getDateTimeFromUser() {
        System.out.println("Enter Date (yyyy.MM.dd HH:mm-2012.12.12 12:12)");
        String datetime = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
        return LocalDateTime.parse(datetime, formatter);
    }

    private VaccinationType getVaccinationTypeFromUser() {
        System.out.println("Choose type of vaccination");
        for (int i = 0; i < VaccinationType.values().length; i++) {
            System.out.println((i + 1) + ". " + VaccinationType.values()[i].toString());
        }
        return VaccinationType.values()[Integer.parseInt(scanner.nextLine()) - 1];
    }

    public void generation() {
        System.out.println("Enter zip");
        String zip = scanner.nextLine();
        List<Citizen> citizens = new CitizensDao(dataSource).selectByZip(zip);
        System.out.println("Enter file name");
        String pathString = scanner.nextLine();
        new VaccinatedByCityWriter().writer(citizens, pathString);
    }

    public void registrationFromList() {
        List<Citizen> citizens = citizensFromFile();
        CitizensDao citizensDao = new CitizensDao(dataSource);
        citizensDao.saveListOfCitizen(citizens);
    }

    private List<Citizen> citizensFromFile() {
        List<Citizen> result = new ArrayList<>();
        Path path = Path.of("src/main/resources/covid/data.csv");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                result.add(new Citizen(
                        parts[0],
                        parts[1],
                        Integer.parseInt(parts[2]),
                        parts[3],
                        parts[4]
                ));
            }
        } catch (IOException ioException) {
            throw new IllegalStateException("Can not read file", ioException);
        }
        return result;
    }

    public void registration() {
        CitizenDataCheck dataCheck = new CitizenDataCheck();
        String name = dataCheck.getParamString(dataCheck::checkName, "Enter your name");
        String zip = dataCheck.getParamString(dataCheck::checkZip, "Enter your zip");
        System.out.println(new CitiesDao(dataSource).listCityByZip(zip));
        int age = dataCheck.getParamInt(dataCheck::checkAge, "Enter your age");
        String email = dataCheck.getParamString(dataCheck::checkEmail, "Enter your email");
        dataCheck.getParamString(dataCheck::checkSecondEmail, "Enter your email again");
        String taj = dataCheck.getParamString(dataCheck::checkTaj, "Enter your TAJ number");
        CitizensDao citizensDao = new CitizensDao(dataSource);
        Citizen citizen = new Citizen(name, zip, age, email, taj);
        citizensDao.saveCitizen(citizen);
    }


    public void vaccinationFail() {
        VaccinationDao vaccinationDao = new VaccinationDao(dataSource);
        CitizensDao citizensDao = new CitizensDao(dataSource);

        System.out.println("Enter your TAJ number");
        String taj = scanner.nextLine();
        if (!(new CitizenDataCheck().checkTaj(taj)) || citizensDao.selectByTaj(taj) == null) {
            System.out.println("Wrong TAJ number");
            return;
        }
        Citizen citizen = citizensDao.selectByTaj(taj);
        LocalDateTime time = getDateTimeFromUser();
        System.out.println("cause of vaccination failure");
        String note = scanner.nextLine();
        vaccinationDao.vaccinationDaoFail(Vaccination.vaccinationFail(citizen.getId(), time, note));


    }

    public void riport() {
        CitizensDao citizensDao  = new CitizensDao(dataSource);
        System.out.println(citizensDao.selectRiport());
    }
}
