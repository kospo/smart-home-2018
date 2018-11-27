package me.kospo.smarthome.event.providers;

import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;
import me.kospo.smarthome.event.SensorEvent;

public class RandomSensorEventProvider {
    public static Event getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) {
            return null; // null means end of event stream
        }
        EventType eventType = EventType.values()[(int) (EventType.values().length * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        return new SensorEvent(eventType, objectId);
    }
}
