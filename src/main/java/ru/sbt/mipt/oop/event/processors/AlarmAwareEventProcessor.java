package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.entity.SmartEntity;
import ru.sbt.mipt.oop.entity.alarm.Alarm;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;

public class AlarmAwareEventProcessor extends AEventProcessor implements EventProcessor {
    private final EventProcessor handler;

    public AlarmAwareEventProcessor(EventProcessor handler) {
        super(EventType.values());

        this.handler = handler;
    }

    @Override
    protected void processEvent0(SmartHome smartHome, Event event) {
        SmartEntity e = smartHome.getResidence().getChild(event.getObjectId(), SmartEntity.class);
        Alarm a = Alarm.getAlarmFor(e);

        if(a == null || !a.isTriggered()) {
            handler.processEvent(smartHome, event);
        }
    }
}
