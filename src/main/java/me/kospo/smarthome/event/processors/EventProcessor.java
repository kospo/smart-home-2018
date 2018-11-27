package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.SmartHome;

public interface EventProcessor {
    void processEvent(SmartHome smartHome, Event event);
}
