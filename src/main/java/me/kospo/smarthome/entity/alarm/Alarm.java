package me.kospo.smarthome.entity.alarm;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;
import me.kospo.smarthome.entity.ASmartEntity;
import me.kospo.smarthome.entity.alarm.state.AlarmState;
import me.kospo.smarthome.entity.alarm.state.AlarmStateArmed;
import me.kospo.smarthome.entity.alarm.state.AlarmStateDisarmed;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.entity.alarm.state.AlarmStateTriggered;

import java.util.Collection;
import java.util.Collections;

public class Alarm extends ASmartEntity implements SmartEntity {
    public static final String MAIN_ALARM_ID = "theAlarm";

    private final int code;
    private AlarmState state;

    public Alarm(String id, int code) {
        super(id);

        this.code = code;
        this.state = new AlarmStateDisarmed();
    }

    public boolean arm(int c) {
        if(c != code) {
            return false;
        }

        if(state.arm()) {
            state = new AlarmStateArmed();

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
            state = new AlarmStateDisarmed();

            return true;
        }

        return false;
    }
    public boolean trigger() {
        if(state.trigger()) {
            if(!isTriggered()) {
                state = new AlarmStateTriggered();
            }

            return true;
        }

        return false;
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

    public static Alarm getAlarmFor(SmartEntity e) {
        SmartEntity parent = e.getParent();
        if(parent == null) {
            return null;
        }

        for (SmartEntity sibling : parent.getChildren()) {
            if(sibling instanceof Alarm) {
                return (Alarm) sibling;
            }
        }

        return getAlarmFor(parent);
    }

    public AlarmState getState() {
        return state;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptySet();
    }
}
