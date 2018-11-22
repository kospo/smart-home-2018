package ru.sbt.mipt.oop.entity;

public abstract class ASmartEntity implements SmartEntity {
    protected final String id;
    protected SmartEntity parent;

    protected ASmartEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public SmartEntity getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
//                "parent=" + (getParent() != null? getParent().getClass().getSimpleName() : null) + "\n" +
//                "children=" + getChildren() + "\n" +
                '}';
    }
}