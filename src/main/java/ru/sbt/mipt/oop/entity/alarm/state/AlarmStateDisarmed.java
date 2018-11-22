package ru.sbt.mipt.oop.entity.alarm.state;

public class AlarmStateDisarmed implements AlarmState {
    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public boolean deactivate() {
        return false;
    }

    @Override
    public boolean trigger() {
        return false;
    }
}
