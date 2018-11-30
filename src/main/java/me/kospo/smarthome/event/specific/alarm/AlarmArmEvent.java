package me.kospo.smarthome.event.specific.alarm;

import me.kospo.smarthome.event.EventType;

public class AlarmArmEvent extends AlarmEvent {
    public AlarmArmEvent(String alarmId, int code) {
        super(EventType.ALARM_ARM, alarmId, code);
    }
}
