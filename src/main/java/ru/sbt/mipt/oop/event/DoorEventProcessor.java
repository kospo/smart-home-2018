package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.model.Door;
import ru.sbt.mipt.oop.model.SmartEntity;

import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.event.SensorEventType.DOOR_OPEN;

public class DoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
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
    public boolean accepts(SensorEventType eventType) {
        return eventType == DOOR_OPEN || eventType == DOOR_CLOSED;
    }
}
