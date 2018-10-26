package ru.sbt.mipt.oop.event.providers;

import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.event.SensorEvent;

public class RandomSensorEventProvider {
    public static SensorEvent getNextSensorEvent() {
        // pretend like we're getting the events from physical world, but here we're going to just generate some random events
        if (Math.random() < 0.05) {
            return null; // null means end of event stream
        }
        EventType eventType = EventType.values()[(int) (4 * Math.random())];
        String objectId = "" + ((int) (10 * Math.random()));

        return new SensorEvent(eventType, objectId);
    }
}
