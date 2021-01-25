package week13d01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityDataMainTest {


    private CityDataMain cityDataMain;

    @BeforeEach
    void init() throws IOException {
        cityDataMain = new CityDataMain("iranyitoszamok-varosok-2021.csv");
    }

    @Test
    void firstCity() {
        System.out.println(cityDataMain.firstCityOrderByCityName());
    }

}