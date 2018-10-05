package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.model.SmartHome;

import java.io.IOException;

public interface SmartHomeStorage {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome() throws IOException;
}
