package me.kospo.smarthome.event.specific.alarm;

import me.kospo.smarthome.event.EventType;

public class AlarmTriggerEvent extends AlarmEvent {
    public AlarmTriggerEvent(String alarmId, int code) {
        super(EventType.ALARM_TRIGGER, alarmId, code);
    }
}
