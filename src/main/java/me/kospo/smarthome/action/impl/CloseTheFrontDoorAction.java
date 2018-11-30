package me.kospo.smarthome.action.impl;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.entity.Door;

public class CloseTheFrontDoorAction extends SmartAction {
    public CloseTheFrontDoorAction(SmartHome smartHome) {
        super(() -> {
            Door front = smartHome.getResidence().getChild(Door.FRONT_ID, Door.class);
            front.setOpened(false);

            SensorCommand cmd = new SensorCommand(CommandType.DOOR_CLOSE, Door.FRONT_ID);
            SensorCommandExecutor.executeCommand(cmd);
        });
    }
}
