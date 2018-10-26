package ru.sbt.mipt.oop.event.alarm;

import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.event.SensorEvent;

public class AlarmEvent extends SensorEvent {
    private final int code;

    protected AlarmEvent(EventType type, int code) {
        super(type, "ALARM");
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
