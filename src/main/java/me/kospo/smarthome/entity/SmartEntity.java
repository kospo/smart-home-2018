package me.kospo.smarthome.entity;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public interface SmartEntity {
    String getId();

    default void applyRecursive(Consumer<SmartEntity> func) {
        func.accept(this);
        for (SmartEntity child : getChildren()) {
            child.applyRecursive(func);
        }
    }
    //todo: redo with streams?
    default SmartEntity findChild(Function<SmartEntity, Boolean> filter) {
        if(filter.apply(this)) {
            return this;
        }

        for (SmartEntity child : getChildren()) {
            SmartEntity ret = child.findChild(filter);

            if(ret != null) {
                return ret;
            }
        }

        return null;
    }

    Collection<SmartEntity> getChildren();

    default <T extends SmartEntity> T getChild(String id, Class<T> cz) {
        return (T)findChild(e -> e.getId().equals(id) && cz.isInstance(e));
    }
}
