package me.kospo.smarthome.entity.alarm.state;

import me.kospo.smarthome.entity.alarm.Alarm;

public abstract class AlarmState {
    protected final Alarm alarm;

    AlarmState(Alarm alarm) {
        this.alarm = alarm;
    }
    public abstract void arm(int c);
    public abstract void disarm(int c);
    public abstract void trigger();
}
