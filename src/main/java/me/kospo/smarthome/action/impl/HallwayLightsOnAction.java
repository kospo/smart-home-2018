package me.kospo.smarthome.action.impl;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;
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

                    SensorCommand cmd = new SensorCommand(CommandType.LIGHT_ON, light.getId());
                    SensorCommandExecutor.executeCommand(cmd);
                }
            });
        });
    }
}
