package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.model.Door;
import ru.sbt.mipt.oop.model.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.model.SmartEntity;

import static ru.sbt.mipt.oop.event.EventType.DOOR_CLOSED;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, Event event) {
        if(!accepts(event.getType())) return;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Door) {
                Door door = (Door) smartEntity;

                if (door.getId().equals(event.getObjectId())) {
                    Room room = (Room)door.getParent();
                    // если мы получили событие о закрытие двери в холле - это значит, что была закрыта входная дверь.
                    // в этом случае мы хотим автоматически выключить свет во всем доме (это же умный дом!)
                    if (room.getId().equals("hall")) {
                        smartHome.turnLightsOff(room);

                        return;
                    }
                }
            }
        }
    }

    @Override
    public boolean accepts(EventType eventType) {
        return eventType == DOOR_CLOSED;
    }
}
