package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeStorage {
    SmartHome loadSmartHome() throws IOException;
    void saveSmartHome() throws IOException;
}
