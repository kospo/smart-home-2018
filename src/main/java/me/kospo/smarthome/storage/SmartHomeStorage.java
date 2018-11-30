package me.kospo.smarthome.storage;

import me.kospo.smarthome.SmartHome;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public interface SmartHomeStorage {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome() throws IOException;
}
