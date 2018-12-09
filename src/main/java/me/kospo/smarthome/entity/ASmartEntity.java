package me.kospo.smarthome.entity;

public abstract class ASmartEntity implements SmartEntity {
    protected final String id;

    protected ASmartEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "children=" + getChildren() + "\n" +
                '}';
    }
}
