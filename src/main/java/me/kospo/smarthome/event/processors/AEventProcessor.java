package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;

import java.util.*;

public abstract class AEventProcessor implements EventProcessor {
    private final Collection<EventType> acceptedTypes;

    protected AEventProcessor(EventType[] types) {
        this(Arrays.asList(types));
    }
    protected AEventProcessor(EventType type, EventType... types) {
        this(new HashSet<EventType>(Arrays.asList(types)) {{
            add(type);
        }});
    }
    protected AEventProcessor(Collection<EventType> types) {
        this.acceptedTypes = types;
    }

    @Override
    public final void processEvent(SmartHome smartHome, Event event) {
        if(!accepts(event.getType())) {
            return;
        }

        processEvent0(smartHome, event);
    }

    protected abstract void processEvent0(SmartHome smartHome, Event event);

    private boolean accepts(EventType eventType) {
        return acceptedTypes.contains(eventType);
    }
}
