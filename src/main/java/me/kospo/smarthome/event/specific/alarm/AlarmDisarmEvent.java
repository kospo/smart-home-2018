package me.kospo.smarthome.event.specific.alarm;

import me.kospo.smarthome.event.EventType;

public class AlarmDisarmEvent extends AlarmEvent {
    public AlarmDisarmEvent(String alarmId, int code) {
        super(EventType.ALARM_DISARM, alarmId, code);
    }
}
