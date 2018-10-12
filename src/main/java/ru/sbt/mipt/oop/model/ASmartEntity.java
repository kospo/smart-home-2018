package ru.sbt.mipt.oop.model;

public abstract class ASmartEntity implements SmartEntity {
    protected transient SmartEntity parent;

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
