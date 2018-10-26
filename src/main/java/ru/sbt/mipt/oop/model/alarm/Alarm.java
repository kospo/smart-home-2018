package ru.sbt.mipt.oop.model.alarm;

public class Alarm {
    private final int code;
    private AlarmState state;

    public Alarm(int code) {
        this.code = code;
        this.state = new AlarmStateOff();
    }

    public boolean activate(int c) {
        if(c != code) {
            return false;
        }

        if(state.activate()) {
            state = new AlarmStateArmed();

            return true;
        }

        return false;
    }

    public boolean deactivate(int c) {
        if(c != code) {
            trigger();

            return false;
        }

        if(state.deactivate()) {
            state = new AlarmStateOff();

            return true;
        }

        return false;
    }

    public boolean trigger() {
        if(state.trigger()) {
            state = new AlarmStateTriggered();

            return true;
        }

        return false;
    }

    public AlarmState getState() {
        return state;
    }
}
