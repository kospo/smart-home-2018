package me.kospo.smarthome;

import me.kospo.smarthome.storage.FileSmartHomeStorage;
import me.kospo.smarthome.event.HomeEventsObserver;
import me.kospo.smarthome.storage.SmartHomeStorage;

import java.io.IOException;

public class Application {
    private static SmartHomeStorage smartHomeStorage = new FileSmartHomeStorage();
    private static SmartHome smartHome;
    private static HomeEventsObserver homeEventsObserver;

    public static void setSmartHomeStorage(SmartHomeStorage smartHomeStorage) {
        Application.smartHomeStorage = smartHomeStorage;
    }

    public static SmartHome getSmartHome() {
        return smartHome;
    }

    public static void main(String... args) throws IOException {
        smartHome = smartHomeStorage.loadSmartHome();
        homeEventsObserver = new HomeEventsObserver(smartHome);
        homeEventsObserver.runEventsCycle();
    }

}
