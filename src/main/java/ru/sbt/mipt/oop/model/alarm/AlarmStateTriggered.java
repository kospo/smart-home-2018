package ru.sbt.mipt.oop.model.alarm;

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
