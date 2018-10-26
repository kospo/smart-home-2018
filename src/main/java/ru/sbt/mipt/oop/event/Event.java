package ru.sbt.mipt.oop.event;

public interface Event {
    public EventType getType();
    public String getObjectId();
}
