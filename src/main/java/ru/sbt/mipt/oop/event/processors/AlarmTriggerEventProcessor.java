package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.model.SmartEntity;
import ru.sbt.mipt.oop.model.alarm.Alarm;

import static ru.sbt.mipt.oop.event.EventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.event.EventType.ALARM_DEACTIVATE;
import static ru.sbt.mipt.oop.event.EventType.ALARM_TRIGGER;

public class AlarmTriggerEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, Event event) {
        if(!accepts(event.getType())) return;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Alarm) {
                Alarm alarm = (Alarm) smartEntity;

                if(alarm.trigger()) {
                    System.out.println("sending alarm sms");
                }
            }
        }
    }

    @Override
    public boolean accepts(EventType eventType) {
        return !(eventType == ALARM_ACTIVATE || eventType == ALARM_DEACTIVATE || eventType == ALARM_TRIGGER);
    }
}
