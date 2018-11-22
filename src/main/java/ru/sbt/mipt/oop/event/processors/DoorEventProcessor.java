package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.entity.alarm.Alarm;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.entity.Door;
import ru.sbt.mipt.oop.entity.SmartEntity;

import static ru.sbt.mipt.oop.event.EventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.EventType.DOOR_OPEN;

public class DoorEventProcessor extends AEventProcessor implements EventProcessor {
    public DoorEventProcessor() {
        super(DOOR_OPEN, DOOR_CLOSED);
    }

    @Override
    public void processEvent0(SmartHome smartHome, Event event) {
        Door door = smartHome.getResidence().getChild(event.getObjectId(), Door.class);

        if (event.getType() == DOOR_OPEN) {
            door.setOpened(true);
            System.out.println("Door " + door.getId() + " was opened.");
        } else {
            door.setOpened(false);
            System.out.println("Door " + door.getId() + " was closed.");
        }
    }
}
