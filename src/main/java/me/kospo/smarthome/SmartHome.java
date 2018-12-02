package me.kospo.smarthome;

import me.kospo.smarthome.entity.House;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.entity.alarm.Alarm;

//@Component
public class SmartHome {
    private final SmartEntity residence;

    public SmartHome(SmartEntity residence) {
        this.residence = residence;
    }

    public SmartEntity getParentOf(SmartEntity child) {
        return getResidence().findChild(smartEntity -> smartEntity.getChildren().contains(child));
    }

    public Alarm getAlarm() {
        return ((House)getResidence().findChild(smartEntity -> smartEntity instanceof House)).getAlarm();
    }

    public SmartEntity getResidence() {
        return residence;
    }

}
