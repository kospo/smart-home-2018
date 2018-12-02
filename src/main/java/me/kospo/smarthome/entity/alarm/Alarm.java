package me.kospo.smarthome.entity.alarm;

import me.kospo.smarthome.entity.ASmartEntity;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.entity.alarm.state.AlarmState;

import java.util.Collection;
import java.util.Collections;

public class Alarm extends ASmartEntity implements SmartEntity {
    public static final String MAIN_ALARM_ID = "theAlarm";

    private final int code;
    private AlarmState state;

    public Alarm(String id, int code) {
        super(id);

        this.code = code;
        this.state = AlarmState.DISARMED; //new AlarmStateDisarmed();
    }

    public boolean arm(int c) {
        if(c != code) {
            return false;
        }

        if(state.arm()) {
            state = AlarmState.ARMED; //new AlarmStateArmed();

            return true;
        }

        return false;
    }
    public boolean disarm(int c) {
        if(c != code) {
            trigger();

            return false;
        }

        if(state.disarm()) {
            state = AlarmState.DISARMED; //new AlarmStateDisarmed();

            return true;
        }

        return false;
    }
    public boolean trigger() {
        if(state.trigger()) {
            if(!isTriggered()) {
                state = AlarmState.TRIGGERED; 
            }

            return true;
        }

        return false;
    }

    public boolean isArmed() {
        return state == AlarmState.ARMED; 
    }
    public boolean isDisarmed() {
        return state == AlarmState.DISARMED; 
    }
    public boolean isTriggered() {
        return state == AlarmState.TRIGGERED; 
    }

    public int getCode() {
        return code;
    }

    public AlarmState getState() {
        return state;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptySet();
    }
}
