package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.entity.*;
import me.kospo.smarthome.event.EventType;
import me.kospo.smarthome.event.specific.SensorEvent;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.Assert.*;

public class TestAll {
    @Test
    public void testDoor() {
        DoorEventProcessor p = new DoorEventProcessor();

        Door door = new Door("test", false);
        SmartHome smartHome = new SmartHome(door);

        p.processEvent(smartHome, new SensorEvent(EventType.DOOR_CLOSE, door.getId()));
        assertFalse(door.isOpened());

        p.processEvent(smartHome, new SensorEvent(EventType.DOOR_OPEN, door.getId()));
        assertTrue(door.isOpened());
    }

    @Test
    public void testLight() {
        LightsEventProcessor p = new LightsEventProcessor();

        Light light = new Light("test", false);
        SmartHome smartHome = new SmartHome(light);

        p.processEvent(smartHome, new SensorEvent(EventType.LIGHT_OFF, light.getId()));
        assertFalse(light.isOn());

        p.processEvent(smartHome, new SensorEvent(EventType.LIGHT_ON, light.getId()));
        assertTrue(light.isOn());
    }

    @Test
    public void testHallDoor() {
        HallDoorEventProcessor p = new HallDoorEventProcessor();

        Door door = new Door("test", false);
        Light light1 = new Light("test1", true);
        Light light2 = new Light("test2", true);
        Room hall = new Room(Room.HALL_ID, Arrays.asList(light1, light2), Arrays.asList(door));

        SmartHome smartHome = new SmartHome(hall);

        p.processEvent(smartHome, new SensorEvent(EventType.DOOR_CLOSE, door.getId()));
        assertFalse(light1.isOn());
        assertFalse(light2.isOn());
    }
}
