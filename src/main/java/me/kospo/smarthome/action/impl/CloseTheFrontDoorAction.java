package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.Door;

public class CloseTheFrontDoorAction extends SmartAction {
    public CloseTheFrontDoorAction(SmartHome smartHome) {
        super( () -> {
            Door front = smartHome.getResidence().getChild(Door.FRONT_ID, Door.class);
            front.setOpened(false);
        });
    }
}
