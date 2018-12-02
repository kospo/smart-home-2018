package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.impl.AlarmArmAction;
import me.kospo.smarthome.action.impl.AlarmTriggerAction;
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
        Alarm alarm = smartHome.getAlarm();

        if(alarm == null || alarm.isDisarmed()) {
            handler.processEvent(smartHome, event);
            return;
        } else if(alarm.isArmed()) {
            new AlarmTriggerAction(smartHome).perform();
            alarm.trigger();
        }

        System.out.println("sending alarm sms");
    }
}
