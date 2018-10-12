package ru.sbt.mipt.oop.model;

import java.util.Collection;
import java.util.Collections;

public class Door extends ASmartEntity implements SmartEntity {
    private final String id;
    private boolean isOpen;

    public Door(boolean isOpen, String id) {
        this.isOpen = isOpen;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    @Override
    public Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }
}
