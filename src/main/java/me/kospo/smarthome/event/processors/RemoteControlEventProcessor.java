package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;
import me.kospo.smarthome.event.specific.RemoteControlEvent;

public class RemoteControlEventProcessor extends AEventProcessor {
    public RemoteControlEventProcessor() {
        super(EventType.SIGNAL_FROM_REMOTE);
    }
    
    @Override
    protected void processEvent0(SmartHome smartHome, Event event) {
        RemoteControlEvent controlEvent = (RemoteControlEvent)event;

        smartHome.getRemoteControlRegistry().onButtonPressed(controlEvent.getObjectId(), controlEvent.getButton());
    }
}
