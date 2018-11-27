package me.kospo.smarthome.entity;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;

import java.util.Collection;
import java.util.Collections;

public class Light extends ASmartEntity implements SmartEntity {
    private boolean on;

    public Light(String name, boolean on) {
        super(name);

        this.on = on;
    }

    public boolean isOn() {
        return on;
    }
    public void setOn(boolean on) {
        this.on = on;

        //todo: move?
        CommandType commandType = on? CommandType.LIGHT_ON : CommandType.LIGHT_OFF;
        SensorCommand cmd = new SensorCommand(commandType, id);
        SensorCommandExecutor.executeCommand(cmd);
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
