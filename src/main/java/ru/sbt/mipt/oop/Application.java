package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.event.DoorEventProcessor;
import ru.sbt.mipt.oop.event.LightsEventProcessor;
import ru.sbt.mipt.oop.event.RandomSensorEventProvider;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.model.SmartHome;
import ru.sbt.mipt.oop.storage.FileSmartHomeStorage;

import java.io.IOException;

import static ru.sbt.mipt.oop.event.SensorEventType.*;

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
        runEventsCycle(smartHome);
    }

    private static void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            if (event.getType() == LIGHT_ON || event.getType() == LIGHT_OFF) {
                LightsEventProcessor.processLightEvent(smartHome, event);
            }
            if (event.getType() == DOOR_OPEN || event.getType() == DOOR_CLOSED) {
                DoorEventProcessor.processDoorEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }

}
