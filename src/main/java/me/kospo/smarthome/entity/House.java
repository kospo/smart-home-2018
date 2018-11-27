package me.kospo.smarthome.entity;

import java.util.*;

public class House extends ASmartEntity implements SmartEntity {
    private final Collection<Room> rooms;

    public House(String name, Collection<Room> rooms) {
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
        return new LinkedHashSet<>(rooms);
    }
}
