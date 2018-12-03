package me.kospo.smarthome.entity.alarm.state;

import me.kospo.smarthome.entity.alarm.Alarm;

public class AlarmStateTriggered extends AlarmState {
    public AlarmStateTriggered(Alarm alarm) {
        super(alarm);
    }

    @Override
    public void arm(int c) {
        //nop: impossible
    }

    @Override
    public void disarm(int c) {
        if(c != alarm.getCode()) {
            return;
        }

        alarm.setState(new AlarmStateDisarmed(alarm));
    }

    @Override
    public void trigger() {
        //nop: already
    }
}
