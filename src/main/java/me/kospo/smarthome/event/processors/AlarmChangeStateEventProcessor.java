package me.kospo.smarthome.event.processors;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.entity.alarm.Alarm;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.specific.alarm.AlarmEvent;

import static me.kospo.smarthome.event.EventType.*;

public class AlarmChangeStateEventProcessor extends AEventProcessor implements EventProcessor {
    public AlarmChangeStateEventProcessor() {
        super(ALARM_ARM, ALARM_DISARM, ALARM_TRIGGER);
    }

    @Override
    protected void processEvent0(SmartHome smartHome, Event event) {
        AlarmEvent alarmEvent = (AlarmEvent)event;

        Alarm alarm = smartHome.getResidence().getChild(alarmEvent.getObjectId(), Alarm.class);
        if(alarm != null) {
            switch (alarmEvent.getType()) {
                case ALARM_ARM:
                    alarm.arm(alarmEvent.getCode());
                    break;
                case ALARM_DISARM:
                    alarm.disarm(alarmEvent.getCode());
                    break;
                case ALARM_TRIGGER:
                    alarm.trigger();
                    break;
            }
        }
    }
}
