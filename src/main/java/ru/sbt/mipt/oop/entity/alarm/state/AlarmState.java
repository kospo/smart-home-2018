package ru.sbt.mipt.oop.entity.alarm.state;

public interface AlarmState {
    boolean activate();
    boolean deactivate();
    boolean trigger();
}
