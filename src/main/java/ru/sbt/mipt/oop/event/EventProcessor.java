package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, SensorEvent event);
    boolean accepts(SensorEventType eventType);
}
