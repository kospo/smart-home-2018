package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.entity.alarm.Alarm;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;
import me.kospo.smarthome.entity.SmartEntity;

public class AlarmAwareEventProcessor extends AEventProcessor implements EventProcessor {
    private final EventProcessor handler;

    public AlarmAwareEventProcessor(EventProcessor handler) {
        super(EventType.values());

        this.handler = handler;
    }

    @Override
    protected void processEvent0(SmartHome smartHome, Event event) {
        SmartEntity e = smartHome.getResidence().getChild(event.getObjectId(), SmartEntity.class);
        Alarm alarm = Alarm.getAlarmFor(e);

        if(alarm == null || !alarm.isTriggered()) {
            handler.processEvent(smartHome, event);
        } else {
            System.out.println("sending alarm sms");
        }
    }
}
