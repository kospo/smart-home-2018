package me.kospo.smarthome.entity.alarm.state;

import me.kospo.smarthome.entity.alarm.Alarm;

public class AlarmStateArmed extends AlarmState {
    public AlarmStateArmed(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void arm(int c) {
        //nop: already
    }

    @Override
    public void disarm(int c) {
        if(c != alarm.getCode()) {
            trigger();

            return;
        }

        alarm.setState(new AlarmStateDisarmed(alarm));
    }

    @Override
    public void trigger() {
        alarm.setState(new AlarmStateTriggered(alarm));
    }
}
