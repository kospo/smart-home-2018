package ru.sbt.mipt.oop.model;

import java.util.*;

public class Room extends ASmartEntity implements SmartEntity {
    private Collection<Light> lights;
    private Collection<Door> doors;
    private String name;

    public Room(Collection<Light> lights, Collection<Door> doors, String name) {
        this.lights = lights;
        for (Light light : lights) {
            light.parent = this;
        }
        this.doors = doors;
        for (Door door : doors) {
            door.parent = this;
        }
        this.name = name;
    }

    public Collection<Light> getLights() {
        return lights;
    }

    public Collection<Door> getDoors() {
        return doors;
    }

    public String getName() {
        return name;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        List<SmartEntity> ret = new ArrayList<>();
        ret.addAll(lights);
        ret.addAll(doors);

        return ret;
    }
}
