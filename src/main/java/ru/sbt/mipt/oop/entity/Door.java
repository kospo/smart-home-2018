package ru.sbt.mipt.oop.entity;

import java.util.Collection;
import java.util.Collections;

public class Door extends ASmartEntity implements SmartEntity {
    private boolean opened;

    public Door(String name, boolean opened) {
        super(name);

        this.opened = opened;
    }

    public boolean isOpened() {
        return opened;
    }
    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
