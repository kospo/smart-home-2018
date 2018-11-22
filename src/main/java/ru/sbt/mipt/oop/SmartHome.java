package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.command.CommandType;
import ru.sbt.mipt.oop.command.SensorCommand;
import ru.sbt.mipt.oop.command.SensorCommandExecutor;
import ru.sbt.mipt.oop.entity.Light;
import ru.sbt.mipt.oop.entity.Room;
import ru.sbt.mipt.oop.entity.SmartEntity;

public class SmartHome {
    private final SmartEntity residence;

    public SmartHome(SmartEntity residence) {
        this.residence = residence;
    }

    public SmartEntity getResidence() {
        return residence;
    }

    public void turnLightsOff(Room room) {
        for (SmartEntity entity : room) {
            if(entity instanceof Light) {
                Light light = (Light) entity;

                light.setOn(false);
                SensorCommand command = new SensorCommand(CommandType.LIGHT_OFF, light.getId());
                SensorCommandExecutor.executeCommand(command);
            }
        }
    }
}
