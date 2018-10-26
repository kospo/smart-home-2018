package ru.sbt.mipt.oop.model.alarm;

public class AlarmStateArmed implements AlarmState {
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
