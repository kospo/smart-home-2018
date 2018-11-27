package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.entity.Door;

import static me.kospo.smarthome.event.EventType.DOOR_CLOSE;
import static me.kospo.smarthome.event.EventType.DOOR_OPEN;

public class DoorEventProcessor extends AEventProcessor implements EventProcessor {
    public DoorEventProcessor() {
        super(DOOR_OPEN, DOOR_CLOSE);
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
