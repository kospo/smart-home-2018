package me.kospo.smarthome.storage;

import me.kospo.smarthome.SmartHome;

import java.io.IOException;

public interface SmartHomeStorage {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome() throws IOException;
}
