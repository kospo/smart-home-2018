package me.kospo.smarthome.entity.alarm;

import me.kospo.smarthome.entity.ASmartEntity;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.entity.alarm.state.AlarmState;
import me.kospo.smarthome.entity.alarm.state.AlarmStateArmed;
import me.kospo.smarthome.entity.alarm.state.AlarmStateDisarmed;
import me.kospo.smarthome.entity.alarm.state.AlarmStateTriggered;

import java.util.Collection;
import java.util.Collections;

public class Alarm extends ASmartEntity implements SmartEntity {
    public static final String MAIN_ALARM_ID = "the_alarm";

    private final int code;
    private AlarmState state;

    public Alarm(String id, int code) {
        super(id);

        this.code = code;
        this.state = new AlarmStateDisarmed(this);
    }

    public void arm(int c) {
        state.arm(c);
    }
    public void disarm(int c) {
        state.disarm(c);
    }
    public void trigger() {
        state.trigger();
    }

    public boolean isArmed() {
        return state instanceof AlarmStateArmed;
    }
    public boolean isDisarmed() {
        return state instanceof AlarmStateDisarmed;
    }
    public boolean isTriggered() {
        return state instanceof AlarmStateTriggered;
    }

    public int getCode() {
        return code;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptySet();
    }

    public void setState(AlarmState state) {
        this.state = state;
    }
}
