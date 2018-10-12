package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.command.CommandType;
import ru.sbt.mipt.oop.command.SensorCommand;
import ru.sbt.mipt.oop.command.SensorCommandExecutor;
import ru.sbt.mipt.oop.model.Door;
import ru.sbt.mipt.oop.model.Light;
import ru.sbt.mipt.oop.model.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.model.SmartEntity;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.SensorEventType.LIGHT_ON;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if(!accepts(event.getType())) return;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Door) {
                Door door = (Door) smartEntity;

                if (door.getId().equals(event.getObjectId())) {
                    Room room = (Room)door.getParent();
                    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getName().equals("hall")) {
                        smartHome.turnLightsOff(room);

                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean accepts(SensorEventType eventType) {
        return eventType == DOOR_CLOSED;
    }
}
