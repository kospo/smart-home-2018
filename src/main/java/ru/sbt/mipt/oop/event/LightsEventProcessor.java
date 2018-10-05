package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.model.Light;
import ru.sbt.mipt.oop.model.Room;
import ru.sbt.mipt.oop.model.SmartHome;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightsEventProcessor {
    public static void processLightEvent(SmartHome smartHome, SensorEvent event) {
        for (Room room : smartHome.getRooms()) {
            for (Light light : room.getLights()) {
                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " in room " + room.getName() + " was turned off.");
                    }
                }
            }
        }
    }
}
