package me.kospo.smarthome.event.specific.alarm;

import me.kospo.smarthome.event.EventType;
import me.kospo.smarthome.event.specific.SensorEvent;

public class AlarmEvent extends SensorEvent {
    private final int code;

    protected AlarmEvent(EventType type, String alarmId, int code) {
        super(type, alarmId);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
