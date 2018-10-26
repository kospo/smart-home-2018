package ru.sbt.mipt.oop.model.alarm;

public class AlarmStateOff implements AlarmState {
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
