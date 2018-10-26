package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.model.Door;
import ru.sbt.mipt.oop.model.SmartEntity;

import static ru.sbt.mipt.oop.event.EventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.EventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, Event event) {
        if(!accepts(event.getType())) return;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Door) {
                Door door = (Door) smartEntity;

                if (door.getId().equals(event.getObjectId())) {
                    if (event.getType() == DOOR_OPEN) {
                        door.setOpen(true);
                        System.out.println("Door " + door.getId() + " was opened.");
                    } else {
                        door.setOpen(false);
                        System.out.println("Door " + door.getId() + " was closed.");
                    }
                }
            }
        }
    }

    @Override
    public boolean accepts(EventType eventType) {
        return eventType == DOOR_OPEN || eventType == DOOR_CLOSED;
    }
}
