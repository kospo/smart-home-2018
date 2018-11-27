package me.kospo.smarthome;

import com.coolcompany.smarthome.command.CommandType;
import com.coolcompany.smarthome.command.SensorCommand;
import com.coolcompany.smarthome.command.SensorCommandExecutor;
import com.coolcompany.smarthome.remote.RemoteControlRegistry;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.remote.RemoteControlRegistryImpl;

public class SmartHome {
    private final SmartEntity residence;
    private final RemoteControlRegistry remoteControlRegistry;

    public SmartHome(SmartEntity residence) {
        this.residence = residence;
        this.remoteControlRegistry = new RemoteControlRegistryImpl();
    }

    public SmartEntity getResidence() {
        return residence;
    }

    public RemoteControlRegistry getRemoteControlRegistry() {
        return remoteControlRegistry;
    }

    public void turnLightsOff(Room room) {
        for (SmartEntity entity : room.getChildren()) {
            if(entity instanceof Light) {
                Light light = (Light) entity;

                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }
}
