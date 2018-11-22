package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.alarm.AlarmEvent;
import ru.sbt.mipt.oop.entity.SmartEntity;
import ru.sbt.mipt.oop.entity.alarm.Alarm;

import static ru.sbt.mipt.oop.event.EventType.*;

public class AlarmEventProcessor extends AEventProcessor implements EventProcessor {
    public AlarmEventProcessor() {
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
