package me.kospo.smarthome.entity;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;

import java.util.Collection;
import java.util.Collections;

public class Door extends ASmartEntity implements SmartEntity {
    public static final String FRONT_ID = "front";

    private boolean opened;

    public Door(String name, boolean opened) {
        super(name);

        this.opened = opened;
    }

    public boolean isOpened() {
        return opened;
    }
    public void setOpened(boolean opened) {
        this.opened = opened;

        //todo: move?
        CommandType commandType = opened? CommandType.DOOR_OPEN : CommandType.DOOR_CLOSE;
        SensorCommand cmd = new SensorCommand(commandType, id);
        SensorCommandExecutor.executeCommand(cmd);
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
