package ru.sbt.mipt.oop.model.alarm;

public interface AlarmState {
//    OFF,
//    ARMED,
//    TRIGGERED
    public boolean activate();
    public boolean deactivate();
    public boolean trigger();
}
