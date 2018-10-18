package ru.sbt.mipt.oop.event;

import ru.sbt.mipt.oop.Application;
import ru.sbt.mipt.oop.SmartHome;

import java.util.Arrays;
import java.util.List;

public class HomeEventsObserver {
    private static final List<EventProcessor> processors = Arrays.asList(
            new DoorEventProcessor(),
            new LightsEventProcessor(),
            new HallDoorEventProcessor()
    );

    public static void runEventsCycle(SmartHome smartHome) {
        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for (EventProcessor processor : processors) {
                processor.processEvent(smartHome, event);
            }
            event = RandomSensorEventProvider.getNextSensorEvent();
        }
    }
}
