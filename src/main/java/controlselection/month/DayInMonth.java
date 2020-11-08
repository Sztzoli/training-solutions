package controlselection.month;


public class DayInMonth {
    public int daysInMonth(int year, String month) {
        int number;
        switch (month.toLowerCase()) {
            case "Január":
                number= 31;
                break;
            case "Február":
                number = (year%4==0 && year%100!=0) ? 29 : year%400==0 ? 29 : 28;
                break;
            case "Március":
                number= 31;
                break;
            case "Április":
                number = 30;
                break;
            case "Május":
                number= 31;
                break;
            case "Június":
                number = 30;
                break;
            case "Július":
                number= 31;
                break;
            case "Augusztus":
                number= 31;
                break;
            case "Szeptember":
                number = 30;
                break;
            case "Október":
                number= 31;
                break;
            case "November":
                number = 30;
                break;
            case "December":
                number= 31;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return number;
    }

}
