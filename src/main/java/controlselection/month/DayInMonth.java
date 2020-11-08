package controlselection.month;


public class DayInMonth {
    public int daysInMonth(int year, String month) {
        int number;
        switch (month.toLowerCase()) {
            case "január":
                number= 31;
                break;
            case "február":
                number = (year%4==0 && year%100!=0) ? 29 : year%400==0 ? 29 : 28;
                break;
            case "március":
                number= 31;
                break;
            case "április":
                number = 30;
                break;
            case "május":
                number= 31;
                break;
            case "június":
                number = 30;
                break;
            case "július":
                number= 31;
                break;
            case "augusztus":
                number= 31;
                break;
            case "szeptember":
                number = 30;
                break;
            case "október":
                number= 31;
                break;
            case "november":
                number = 30;
                break;
            case "december":
                number= 31;
                break;
            default:
                throw new IllegalArgumentException("Invalid month: " + month);
        }
        return number;
    }

}
