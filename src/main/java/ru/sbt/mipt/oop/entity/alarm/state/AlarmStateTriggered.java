package ru.sbt.mipt.oop.entity.alarm.state;

public class AlarmStateTriggered implements AlarmState {
    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public boolean deactivate() {
        return true;
    }

    @Override
    public boolean trigger() {
        return true;
    }
}
