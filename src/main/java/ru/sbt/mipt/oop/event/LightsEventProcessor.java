package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.model.Light;
import ru.sbt.mipt.oop.model.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.model.SmartEntity;

import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class LightsEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!accepts(event.getType())) return;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Light) {
                Light light = (Light) smartEntity;

                if (light.getId().equals(event.getObjectId())) {
                    if (event.getType() == LIGHT_ON) {
                        light.setOn(true);
                        System.out.println("Light " + light.getId() + " was turned on.");
                    } else {
                        light.setOn(false);
                        System.out.println("Light " + light.getId() + " was turned off.");
                    }
                }
            }
        }
    }

    @Override
    public boolean accepts(SensorEventType eventType) {
        return eventType == LIGHT_ON || eventType == LIGHT_OFF;
    }
}
