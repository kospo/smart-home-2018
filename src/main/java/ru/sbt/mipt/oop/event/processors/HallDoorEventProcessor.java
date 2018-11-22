package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.entity.Door;
import ru.sbt.mipt.oop.entity.Room;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.entity.SmartEntity;

import static ru.sbt.mipt.oop.event.EventType.DOOR_CLOSED;

public class HallDoorEventProcessor extends AEventProcessor implements EventProcessor {
    public static final String HALL_ROOM_ID = "hall";

    public HallDoorEventProcessor() {
        super(DOOR_CLOSED);
    }

    @Override
    public void processEvent0(SmartHome smartHome, Event event) {
        Door door = smartHome.getResidence().getChild(event.getObjectId(), Door.class);
        Room room = (Room)door.getParent();

        if (room.getId().equals(HALL_ROOM_ID)) {
            smartHome.turnLightsOff(room);
        }
    }
}
