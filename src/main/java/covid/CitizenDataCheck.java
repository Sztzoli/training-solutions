package covid;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.Predicate;

public class CitizenDataCheck {

    private String email;

    Scanner scanner = new Scanner(System.in);
    public static final int TAJ_LAST_INDEX = 8;
    public static final String VALID_PARAMS_DESC =
            """
                    Name cannot be empty
                    Zip code need to be exist
                    Age between 10 and 150
                    Email bigger than 3 characters and contains: @
                    TAJ number need to be exist
                    """;


    public boolean checkName(String name) {
        return !(name == null || name.isBlank());

    }

    public boolean checkZip(String zip){
        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/covid?useUnicode=true");
            dataSource.setUser("covid");
            dataSource.setPassword("covid");
        } catch (SQLException sqle) {
            throw new IllegalStateException("Cannot connect", sqle);
        }
        return ! new CitiesDao(dataSource).listCityByZip(zip).isEmpty();
    }

    public boolean checkAge(int age) {
        return (age > 10 && age < 150);
    }

    public boolean checkEmail(String email) {
        if (email.length() >= 3 && email.contains("@")) {
            this.email = email;
            return true;
        }
        return false;
    }

    public boolean checkSecondEmail( String secondEmail) {
        return (email.equals(secondEmail));
    }

    public boolean checkTaj(String taj) {
        return (validateTajNumber(taj) && tajCDV(taj));
    }

    private boolean tajCDV(String taj) {
        int result = 0;
        int lastDigit = taj.charAt(TAJ_LAST_INDEX) - '0';
        for (int i = 0; i < TAJ_LAST_INDEX; i++) {
            int digit = taj.charAt(i) - '0';
            if (i % 2 == 0) {
                result += (digit * 3);
            } else {
                result += (digit * 7);
            }
        }
        return (result % 10 == lastDigit);
    }

    private boolean validateTajNumber(String taj) {
        return (taj.length() == 9 && taj.matches("[0-9]+"));
    }

    public String getParamString(Predicate<String> predicate, String text) {
        String param = null;
        boolean validParam = false;
        while (!validParam) {
            System.out.println(text);
            String paramTemp = scanner.nextLine();
            if (predicate.test(paramTemp)) {
                param = paramTemp;
                validParam = true;
            } else {
                System.out.println("Invalid data: " + paramTemp);
                System.out.println(VALID_PARAMS_DESC);
            }
        }
        return param;
    }


    public Integer getParamInt(Predicate<Integer> predicate, String text) {
        Integer param = null;
        boolean validParam = false;
        while (!validParam) {
            System.out.println(text);
            int paramTemp = Integer.parseInt(scanner.nextLine());
            if (predicate.test(paramTemp)) {
                param = paramTemp;
                validParam = true;
            } else {
                System.out.println("Invalid data: " + paramTemp);
                System.out.println(VALID_PARAMS_DESC);
            }
        }
        return param;
    }

}
