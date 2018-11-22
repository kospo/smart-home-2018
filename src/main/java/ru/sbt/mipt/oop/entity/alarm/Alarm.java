package ru.sbt.mipt.oop.entity.alarm;

import ru.sbt.mipt.oop.entity.ASmartEntity;
import ru.sbt.mipt.oop.entity.SmartEntity;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmState;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateArmed;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateDisarmed;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateTriggered;

import java.util.Collection;
import java.util.Collections;

public class Alarm extends ASmartEntity implements SmartEntity {
    private final int code;
    private AlarmState state;

    public Alarm(String name, int code) {
        super(name);

        this.code = code;
        this.state = new AlarmStateDisarmed();
    }

    public boolean arm(int c) {
        if(c != code) {
            return false;
        }

        if(state.activate()) {
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

        if(state.deactivate()) {
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
