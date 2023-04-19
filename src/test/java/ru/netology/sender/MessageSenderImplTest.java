package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static ru.netology.sender.MessageSenderImpl.IP_ADDRESS_HEADER;

class MessageSenderImplTest {
    @Test
    void sendRussia() {
        String ID = "172.123.12.19";
        String messageTestSender = "Добро пожаловать";
        String messageSender;
        LocalizationServiceImpl localizationService = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, ID);
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ID)).thenReturn(new Location("Moscow", Country.RUSSIA, "Lenina", 15));
        MessageSenderImpl sender = new MessageSenderImpl(geoService, localizationService);
        messageSender = sender.send(headers);
        Assertions.assertEquals(messageTestSender, messageSender);
    }
    @Test
    void sendUSA() {
        String ID = "172.123.12.19";
        String messageTestSender = "Welcome";
        String messageSender;
        LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(IP_ADDRESS_HEADER, ID);
        GeoServiceImpl geoService = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoService.byIp(ID)).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));
        MessageSenderImpl sender = new MessageSenderImpl(geoService, localizationService);
        messageSender = sender.send(headers);
        Assertions.assertEquals(messageTestSender, messageSender);
    }
}