package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.impl.LightsOffAction;
import me.kospo.smarthome.entity.Door;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;

public class HallDoorEventProcessor extends AEventProcessor implements EventProcessor {

    public HallDoorEventProcessor() {
        super(EventType.DOOR_CLOSE);
    }

    @Override
    public void processEvent0(SmartHome smartHome, Event event) {
        Door door = smartHome.getResidence().getChild(event.getObjectId(), Door.class);
        Room room = (Room)door.getParent();

        if (room.getId().equals(Room.HALL_ID)) {
            new LightsOffAction(smartHome).perform();
        }
    }
}
