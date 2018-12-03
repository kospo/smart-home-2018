package me.kospo.smarthome.entity.alarm.state;

import me.kospo.smarthome.entity.alarm.Alarm;

public class AlarmStateDisarmed extends AlarmState {
    public AlarmStateDisarmed(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void arm(int c) {
        if(c != alarm.getCode()) {
            return;
        }

        alarm.setState(new AlarmStateArmed(alarm));
    }

    @Override
    public void disarm(int c) {
        //nop: already
    }

    @Override
    public void trigger() {
        //nop: impossible
    }
}
