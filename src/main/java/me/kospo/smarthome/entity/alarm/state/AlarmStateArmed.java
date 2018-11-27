package me.kospo.smarthome.entity.alarm.state;

public class AlarmStateArmed implements AlarmState {
    @Override
    public boolean arm() {
        return false;
    }

    @Override
    public boolean disarm() {
        return true;
    }

    @Override
    public boolean trigger() {
        return true;
    }
}
