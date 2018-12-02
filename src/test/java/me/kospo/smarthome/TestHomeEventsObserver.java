package me.kospo.smarthome;

import com.coolcompany.smarthome.events.SensorEventsManager;
import me.kospo.smarthome.entity.Door;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.HomeEventsObserver;
import me.kospo.smarthome.event.processors.EventProcessor;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestHomeEventsObserver {

    private MockEventProcessor eventProcessor;

    @Test
    public void test() {
        Door door = new Door("test", false);
        Light light1 = new Light("test1", true);
        Light light2 = new Light("test2", true);
        Room hall = new Room(Room.HALL_ID, Arrays.asList(light1, light2), Arrays.asList(door));

        SmartHome smartHome = new SmartHome(hall);

        //todo: no idea how to test this properly
        eventProcessor = new MockEventProcessor();
        MockSensorEventsManager eventsManager = new MockSensorEventsManager();
        HomeEventsObserver observer = new HomeEventsObserver(smartHome, eventsManager, Arrays.asList(eventProcessor));
        observer.runEventsCycle();
        assertEquals(eventsManager.counter, 1);
    }

    private class MockSensorEventsManager extends SensorEventsManager {
        private int counter = 0;

        @Override
        public void start() {
            counter++;
        }
    }
    private class MockEventProcessor implements EventProcessor {
        int counter = 0;

        @Override
        public void processEvent(SmartHome smartHome, Event event) {
            counter++;
            throw new RuntimeException();
        }
    }
}
