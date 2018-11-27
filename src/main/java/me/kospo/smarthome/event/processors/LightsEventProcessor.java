package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.SmartHome;

import static me.kospo.smarthome.event.EventType.LIGHT_OFF;
import static me.kospo.smarthome.event.EventType.LIGHT_ON;

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
