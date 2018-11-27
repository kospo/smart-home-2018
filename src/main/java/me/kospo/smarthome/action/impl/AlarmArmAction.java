package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.alarm.Alarm;

public class AlarmArmAction extends SmartAction {
    public AlarmArmAction(SmartHome smartHome) {
        super(() -> {
            smartHome.getResidence().applyRecursive(smartEntity -> {
                if(smartEntity instanceof Alarm) {
                    Alarm alarm = (Alarm) smartEntity;
                    alarm.arm(alarm.getCode());
                }
            });
        });
    }
}
