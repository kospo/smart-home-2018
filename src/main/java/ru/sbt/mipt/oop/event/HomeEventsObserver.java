package ru.sbt.mipt.oop.event;

import com.coolcompany.smarthome.events.CCSensorEvent;
import com.coolcompany.smarthome.events.EventHandler;
import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.processors.*;

import java.util.Arrays;
import java.util.List;

public class HomeEventsObserver {
    private static final List<EventProcessor> processors = Arrays.asList(
            new AlarmEventProcessor(),
            new AlarmTriggerEventProcessor(),

            new AlarmAwareEventProcessor(new DoorEventProcessor()),
            new AlarmAwareEventProcessor(new HallDoorEventProcessor()),

            new AlarmAwareEventProcessor(new LightsEventProcessor())
    );

    public static void runEventsCycle(SmartHome smartHome) {
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        for (EventProcessor processor : processors) {
            EventProcessorAdapter adapter = new EventProcessorAdapter(smartHome, processor);
            sensorEventsManager.registerEventHandler(adapter::handleEvent);
        }
        sensorEventsManager.start();

//        SensorEvent event = RandomSensorEventProvider.getNextSensorEvent();
//        while (event != null) {
//            System.out.println("Got event: " + event);
//            for (EventProcessor processor : processors) {
//                processor.processEvent(smartHome, event);
//            }
//            event = RandomSensorEventProvider.getNextSensorEvent();
//        }
    }
}
