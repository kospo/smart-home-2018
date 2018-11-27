package me.kospo.smarthome.entity.alarm.state;

public interface AlarmState {
    boolean arm();
    boolean disarm();
    boolean trigger();
}
