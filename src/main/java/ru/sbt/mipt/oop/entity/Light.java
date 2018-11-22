package ru.sbt.mipt.oop.entity;

import java.util.Collection;
import java.util.Collections;

public class Light extends ASmartEntity implements SmartEntity {
    private boolean on;

    public Light(String name, boolean on) {
        super(name);

        this.on = on;
    }

    public boolean isOn() {
        return on;
    }
    public void setOn(boolean on) {
        this.on = on;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
