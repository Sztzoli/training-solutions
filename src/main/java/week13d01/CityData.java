package week13d01;

public class CityData {

    private String zipcode;
    private String city;
    private String cityDistrict;

    public CityData(String zipcode, String city, String cityDistrict) {
        this(zipcode, city);
        this.cityDistrict = cityDistrict;
    }

    public CityData(){

    };

    public CityData(String zipcode, String city) {
        this.zipcode = zipcode;
        this.city = city;
    }

    public static CityData createCityByLine(String fullRepresentation) {
        CityData cityData = new CityData();
        String parts[] = fullRepresentation.split(";");
        cityData.zipcode = parts[0];
        cityData.city = parts[1];
        if (parts.length==3){
            cityData.cityDistrict = parts[2];
        }
        return cityData;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    @Override
    public String toString() {
        return city + " " + zipcode;
    }
}
