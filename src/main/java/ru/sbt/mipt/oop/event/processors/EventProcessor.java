package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, Event event);
}
