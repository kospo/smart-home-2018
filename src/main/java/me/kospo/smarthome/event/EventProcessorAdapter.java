package me.kospo.smarthome.event;

import com.coolcompany.smarthome.events.CCSensorEvent;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.processors.EventProcessor;

import java.util.HashMap;
import java.util.Map;

public class EventProcessorAdapter {
    private static final Map<String, EventType> map = new HashMap<>();
    static {
        //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
        map.put("LightIsOn", EventType.LIGHT_ON);
        map.put("LightIsOff", EventType.LIGHT_OFF);
        map.put("DoorIsOpen", EventType.DOOR_OPEN);
        map.put("DoorIsClosed", EventType.DOOR_CLOSE);
        map.put("DoorIsLocked", EventType.DOOR_LOCK);
        map.put("DoorIsUnlocked", EventType.DOOR_UNLOCK);
    }

    private final SmartHome smartHome;
    private final EventProcessor processor;

    public EventProcessorAdapter(SmartHome smartHome, EventProcessor processor) {
        this.smartHome = smartHome;
        this.processor = processor;
    }

    public void handleEvent(CCSensorEvent ccEvent) {
        String objectId = ccEvent.getObjectId();
        String ccType = ccEvent.getEventType();

        EventType eventType = map.get(ccType);
        Event event = new SensorEvent(eventType, objectId);
        processor.processEvent(smartHome, event);
    }
}
