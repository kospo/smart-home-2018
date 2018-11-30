package me.kospo.smarthome.event;

import com.coolcompany.smarthome.events.SensorEventsManager;
import com.coolcompany.smarthome.remote.RemoteControlRegistry;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.processors.*;
import me.kospo.smarthome.remote.RemoteControlRegistryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class HomeEventsObserver {
    private static final List<EventProcessor> processors = Arrays.asList(
            new AlarmChangeStateEventProcessor(),

            new AlarmAwareEventProcessor(new DoorEventProcessor()),
            new AlarmAwareEventProcessor(new HallDoorEventProcessor()),
            new AlarmAwareEventProcessor(new LightsEventProcessor())
    );

    private final SmartHome smartHome;
    private final SensorEventsManager sensorEventsManager;

    public HomeEventsObserver(SmartHome smartHome) {
        this.smartHome = smartHome;
        this.sensorEventsManager = new SensorEventsManager();
    }

    public void runEventsCycle() {
        registerProcessors();
        registerRemoteControls();
        sensorEventsManager.start();
    }

    private void registerRemoteControls() {
        //todo
//        smartHome.getRemoteControlRegistry().registerRemoteControl();
    }

    private void registerProcessors() {
        for (EventProcessor processor : processors) {
            EventProcessorAdapter adapter = new EventProcessorAdapter(smartHome, processor);
            sensorEventsManager.registerEventHandler(adapter::handleEvent);
        }
    }
}
