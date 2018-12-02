package me.kospo.smarthome;

import me.kospo.smarthome.entity.Door;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.entity.SmartEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestApply {
    @Test
    public void test() {
        Door door = new Door("test", false);
        Light light1 = new Light("test1", true);
        Light light2 = new Light("test2", true);
        Room hall = new Room(Room.HALL_ID, Arrays.asList(light1, light2), Arrays.asList(door));

        SmartHome smartHome = new SmartHome(hall);

        List<SmartEntity> list = new ArrayList<>();
        smartHome.getResidence().applyRecursive(list::add);

        assertEquals(4, list.size());
        assertTrue(list.contains(hall));
        assertTrue(list.contains(light1));
        assertTrue(list.contains(light2));
        assertTrue(list.contains(door));
    }

}
