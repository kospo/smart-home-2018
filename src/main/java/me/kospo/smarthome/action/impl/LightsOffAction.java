package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.Light;

public class LightsOffAction extends SmartAction {
    public LightsOffAction(SmartHome smartHome) {
        super(() -> {
            smartHome.getResidence().applyRecursive(smartEntity -> {
                if (smartEntity instanceof Light) {
                    Light light = (Light) smartEntity;
                    light.setOn(false);
                }
            });
        });
    }
}
