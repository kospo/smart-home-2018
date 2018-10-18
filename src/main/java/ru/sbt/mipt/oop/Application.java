package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.HomeEventsObserver;
import ru.sbt.mipt.oop.storage.FileSmartHomeStorage;

import java.io.IOException;

public class Application {
    private static SmartHomeStorage smartHomeStorage = new FileSmartHomeStorage();
    private static SmartHome smartHome;

    public static void setSmartHomeStorage(SmartHomeStorage smartHomeStorage) {
        Application.smartHomeStorage = smartHomeStorage;
    }

    public static SmartHome getSmartHome() {
        return smartHome;
    }

    public static void main(String... args) throws IOException {
        smartHome = smartHomeStorage.loadSmartHome();
        HomeEventsObserver.runEventsCycle(smartHome);
    }

}
