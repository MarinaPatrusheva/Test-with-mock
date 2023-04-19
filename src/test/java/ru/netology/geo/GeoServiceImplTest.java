package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIp() {
        String MOSCOW_IP = "172.0.32.11";
        GeoServiceImpl geoService = new GeoServiceImpl();
        Location location = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
        Assertions.assertEquals(geoService.byIp(MOSCOW_IP).getCountry(),location.getCountry());
        Assertions.assertEquals(geoService.byIp(MOSCOW_IP).getBuiling(), location.getBuiling());
        Assertions.assertEquals(geoService.byIp(MOSCOW_IP).getCity(), location.getCity());
        Assertions.assertEquals(geoService.byIp(MOSCOW_IP).getStreet(), location.getStreet());
    }
}