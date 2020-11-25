package defaultconstructor.date;

public class SimpleDateFormatter {
    private CountryCode countryCode;

    public SimpleDateFormatter() {
        countryCode = CountryCode.HU;
    }

    public String formatDateString(SimpleDate simpleDate) {
        return String.format("%d-%d-%d", simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay());
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        String formatedString="";
        switch (countryCode) {
            case HU:
                formatedString = formatDateString(simpleDate);
                break;
            case EN:
                formatedString = String.format("%d-%d-%d", simpleDate.getDay(), simpleDate.getMonth(), simpleDate.getYear());
                break;
            case US:
                formatedString = String.format("%d-%d-%d", simpleDate.getMonth(), simpleDate.getDay(), simpleDate.getYear());
                break;
        }
        return formatedString;
    }

}
