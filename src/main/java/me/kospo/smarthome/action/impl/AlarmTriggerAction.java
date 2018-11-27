package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.alarm.Alarm;

public class AlarmTriggerAction extends SmartAction {
    public AlarmTriggerAction(SmartHome smartHome) {
        super( () -> {
            smartHome.getResidence().applyRecursive(smartEntity -> {
                if(smartEntity instanceof Alarm) {
                    Alarm alarm = (Alarm) smartEntity;
                    alarm.trigger();
                }
            });
        });
    }
}
