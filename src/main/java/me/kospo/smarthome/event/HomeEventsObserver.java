package me.kospo.smarthome.event;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.coolcompany.smarthome.remote.RemoteControlRegistry;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.processors.*;
import me.kospo.smarthome.remote.RemoteControlImpl;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HomeEventsObserver {
    private final SmartHome smartHome;
    private final List<EventProcessor> processors;
    private final SensorEventsManager sensorEventsManager;

    public HomeEventsObserver(SmartHome smartHome) {
        this(smartHome, new SensorEventsManager(), Arrays.asList(
                new AlarmChangeStateEventProcessor(),

                new AlarmAwareEventProcessor(new DoorEventProcessor()),
                new AlarmAwareEventProcessor(new HallDoorEventProcessor()),
                new AlarmAwareEventProcessor(new LightsEventProcessor())
        ));
    }

    public HomeEventsObserver(SmartHome smartHome, SensorEventsManager eventsManager, List<EventProcessor> processors) {
        this.smartHome = smartHome;
        this.sensorEventsManager = eventsManager;
        this.processors = processors;
    }

    public void runEventsCycle() {
        registerProcessors();
        registerRemoteControls();
        sensorEventsManager.start();
    }

    private void registerRemoteControls() {
        RemoteControlImpl remote1 = new RemoteControlImpl("remote1");
        RemoteControlRegistry.registerRemoteControl(remote1, remote1.getId());
    }

    private void registerProcessors() {
        for (EventProcessor processor : processors) {
            EventProcessorAdapter adapter = new EventProcessorAdapter(smartHome, processor);
            sensorEventsManager.registerEventHandler(adapter::handleEvent);
        }
    }
}
