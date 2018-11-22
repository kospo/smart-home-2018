package ru.sbt.mipt.oop.entity;

import java.util.*;

public class Room extends ASmartEntity implements SmartEntity {
    private Collection<Light> lights;
    private Collection<Door> doors;

    public Room(String name, Collection<Light> lights, Collection<Door> doors) {
        super(name);

        this.lights = lights;
        for (Light light : lights) {
            light.parent = this;
        }

        this.doors = doors;
        for (Door door : doors) {
            door.parent = this;
        }
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
