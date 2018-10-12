package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.*;
import ru.sbt.mipt.oop.storage.FileSmartHomeStorage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Application {
    private static SmartHomeStorage smartHomeStorage = new FileSmartHomeStorage();
    private static List<EventProcessor> processors = Arrays.asList(new DoorEventProcessor(), new LightsEventProcessor());
    private static SmartHome smartHome;

    public static void setSmartHomeStorage(SmartHomeStorage smartHomeStorage) {
        Application.smartHomeStorage = smartHomeStorage;
    }

    public static SmartHome getSmartHome() {
        return smartHome;
    }

    public static void main(String... args) throws IOException {
        smartHome = smartHomeStorage.loadSmartHome();
        runEventsCycle(smartHome);
    }

    private static void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor : processors) {
                processor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }

}
