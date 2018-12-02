package me.kospo.smarthome.entity;

import java.util.*;

public class Room extends ASmartEntity implements SmartEntity {
    public static final String HALLWAY_ID = "hallway";
    public static final String HALL_ID = "hall";

    private Collection<Light> lights;
    private Collection<Door> doors;

    public Room(String name, Collection<Light> lights, Collection<Door> doors) {
        super(name);

        this.lights = lights;
        this.doors = doors;
    }

    public Collection<Light> getLights() {
        return lights;
    }
    public Collection<Door> getDoors() {
        return doors;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        Set<SmartEntity> ret = new LinkedHashSet<>();
        ret.addAll(lights);
        ret.addAll(doors);

        return ret;
    }
}
