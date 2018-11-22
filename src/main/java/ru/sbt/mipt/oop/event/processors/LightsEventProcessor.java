package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.entity.Door;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.entity.Light;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.entity.SmartEntity;

import static ru.sbt.mipt.oop.event.EventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.event.EventType.LIGHT_ON;

public class LightsEventProcessor extends AEventProcessor implements EventProcessor {
    public LightsEventProcessor() {
        super(LIGHT_ON, LIGHT_OFF);
    }

    @Override
    public void processEvent0(SmartHome smartHome, Event event) {
        Light light = smartHome.getResidence().getChild(event.getObjectId(), Light.class);
        
        if (event.getType() == LIGHT_ON) {
            light.setOn(true);
            System.out.println("Light " + light.getId() + " was turned on.");
        } else {
            light.setOn(false);
            System.out.println("Light " + light.getId() + " was turned off.");
        }
    }
}
