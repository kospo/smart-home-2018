package me.kospo.smarthome.entity.alarm.state;

public class AlarmStateDisarmed implements AlarmState {
    @Override
    public boolean arm() {
        return true;
    }

    @Override
    public boolean disarm() {
        return false;
    }

    @Override
    public boolean trigger() {
        return false;
    }
}
