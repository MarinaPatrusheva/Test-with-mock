package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeRussia() {
        String message = "Добро пожаловать";
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals(message, localizationService.locale(Country.RUSSIA));
    }
    @Test
    void localeUSA(){
        String message = "Welcome";
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Assertions.assertEquals(message, localizationService.locale(Country.USA));
    }
}