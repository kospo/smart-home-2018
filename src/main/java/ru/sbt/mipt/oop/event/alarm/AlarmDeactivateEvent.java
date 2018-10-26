package ru.sbt.mipt.oop.event.alarm;

import ru.sbt.mipt.oop.event.EventType;

public class AlarmDeactivateEvent extends AlarmEvent {
    public AlarmDeactivateEvent(int code) {
        super(EventType.ALARM_DEACTIVATE, code);
    }
}
