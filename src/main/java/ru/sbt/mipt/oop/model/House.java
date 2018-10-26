package ru.sbt.mipt.oop.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class House extends ASmartEntity implements SmartEntity {
    private final Collection<Room> rooms;

    public House(Collection<Room> rooms, String name) {
        super(name);
        this.rooms = rooms;
        for (Room room : rooms) {
            room.parent = this;
        }
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
