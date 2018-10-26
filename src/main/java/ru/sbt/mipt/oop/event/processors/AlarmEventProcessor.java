package ru.sbt.mipt.oop.event.processors;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.event.Event;
import ru.sbt.mipt.oop.event.EventType;
import ru.sbt.mipt.oop.event.alarm.AlarmEvent;
import ru.sbt.mipt.oop.model.Door;
import ru.sbt.mipt.oop.model.SmartEntity;
import ru.sbt.mipt.oop.model.alarm.Alarm;

import static ru.sbt.mipt.oop.event.EventType.*;

public class AlarmEventProcessor implements EventProcessor {

    @Override
    public void processEvent(SmartHome smartHome, Event event) {
        if(!accepts(event.getType())) return;
        AlarmEvent alarmEvent = (AlarmEvent)event;

        for (SmartEntity smartEntity : smartHome.getResidence()) {
            if(smartEntity instanceof Alarm && smartEntity.getId().equals(alarmEvent.getObjectId())) {
                Alarm alarm = (Alarm) smartEntity;

                switch (alarmEvent.getType()) {
                    case ALARM_ACTIVATE:
                        alarm.activate(alarmEvent.getCode());
                        break;
                    case ALARM_DEACTIVATE:
                        alarm.deactivate(alarmEvent.getCode());
                        break;
                    case ALARM_TRIGGER:
                        alarm.trigger();
                        break;
                }
            }
        }
    }

    @Override
    public boolean accepts(EventType eventType) {
        return eventType == ALARM_ACTIVATE || eventType == ALARM_DEACTIVATE || eventType == ALARM_TRIGGER;
    }
}
