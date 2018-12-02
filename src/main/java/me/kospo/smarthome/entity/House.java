package me.kospo.smarthome.entity;

import me.kospo.smarthome.entity.alarm.Alarm;

import java.util.*;

public class House extends ASmartEntity implements SmartEntity {
    private final Collection<Room> rooms;
    private final Alarm alarm;

    public House(String name, Collection<Room> rooms, Alarm alarm) {
        super(name);

        this.rooms = rooms;
        this.alarm = alarm;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return new LinkedHashSet<>(rooms);
    }

    public Alarm getAlarm() {
        return alarm;
    }
}
