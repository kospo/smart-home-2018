package me.kospo.smarthome;

import com.coolcompany.smarthome.events.SensorEventsManager;
import me.kospo.smarthome.event.HomeEventsObserver;
import me.kospo.smarthome.storage.FileSmartHomeStorage;
import me.kospo.smarthome.storage.SmartHomeStorage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class SmartConfiguration {
    @Bean
    public HomeEventsObserver getHomeEventsObserver(SmartHome smartHome) {
        return new HomeEventsObserver(smartHome);
    }

    @Bean
    public SensorEventsManager getSensorEventsManager() {
        return new SensorEventsManager();
    }

    @Bean
    public SmartHomeStorage getStorage() {
        return new FileSmartHomeStorage("./smart-home-1.js");
    }

    @Bean
    public SmartHome getSmartHome(SmartHomeStorage smartHomeStorage) {
        try {
            return smartHomeStorage.loadSmartHome();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
