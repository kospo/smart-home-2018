package me.kospo.smarthome.event;

public interface Event {
    EventType getType();
    String getObjectId();
}
