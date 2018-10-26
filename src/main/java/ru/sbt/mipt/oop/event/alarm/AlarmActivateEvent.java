package ru.sbt.mipt.oop.event.alarm;

import ru.sbt.mipt.oop.event.EventType;

public class AlarmActivateEvent extends AlarmEvent {
    public AlarmActivateEvent(int code) {
        super(EventType.ALARM_ACTIVATE, code);
    }
}
