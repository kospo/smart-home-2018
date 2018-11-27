package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;

public class HallwayLightsOnAction extends SmartAction {
    public HallwayLightsOnAction(SmartHome smartHome) {
        super( () -> {
            Room hallway = smartHome.getResidence().getChild(Room.HALLWAY_ID, Room.class);
            hallway.applyRecursive(smartEntity -> {
                if(smartEntity instanceof Light) {
                    Light light = (Light) smartEntity;
                    light.setOn(true);
                }
            });
        });
    }
}
