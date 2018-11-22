package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.entity.SmartEntity;
import ru.sbt.mipt.oop.entity.alarm.Alarm;
import ru.sbt.mipt.oop.event.alarm.AlarmEvent;

import static ru.sbt.mipt.oop.event.EventType.ALARM_ARM;
import static ru.sbt.mipt.oop.event.EventType.ALARM_DISARM;
import static ru.sbt.mipt.oop.event.EventType.ALARM_TRIGGER;

public class AlarmTriggerEventProcessor extends AEventProcessor implements EventProcessor {
    public AlarmTriggerEventProcessor() {
        super(ALARM_ARM, ALARM_DISARM, ALARM_TRIGGER);
    }

    @Override
    public void processEvent0(SmartHome smartHome, Event event) {
        Alarm alarm = smartHome.getResidence().getChild(event.getObjectId(), Alarm.class);

        if(alarm.isTriggered()) {
            System.out.println("sending alarm sms");
        }
    }
}
