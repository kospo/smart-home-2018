package ru.sbt.mipt.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class House extends ASmartEntity implements SmartEntity {
    private final Collection<Room> rooms;
    private final String name;

    public House(Collection<Room> rooms, String name) {
        this.rooms = rooms;
        for (Room room : rooms) {
            room.parent = this;
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        List<SmartEntity> ret = new ArrayList<>();
        ret.addAll(rooms);

        return ret;
    }
}
