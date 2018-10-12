package ru.sbt.mipt.oop.model;

import java.util.Collection;
import java.util.Collections;

public class Light extends ASmartEntity implements SmartEntity {
    private boolean isOn;
    private final String id;

    public Light(String id, boolean isOn) {
        this.id = id;
        this.isOn = isOn;
    }

    public boolean isOn() {
        return isOn;
    }

    public String getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
