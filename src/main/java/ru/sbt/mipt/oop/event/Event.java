package ru.sbt.mipt.oop.event;

public interface Event {
    EventType getType();
    String getObjectId();
}
