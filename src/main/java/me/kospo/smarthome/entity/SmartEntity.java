package me.kospo.smarthome.entity;

import java.util.*;
import java.util.function.Consumer;

public interface SmartEntity {
    String getId();
    SmartEntity getParent();
    default void applyRecursive(Consumer<SmartEntity> func) {
        func.accept(this);
        for (SmartEntity child : getChildren()) {
            child.applyRecursive(func);
        }
    }

//    @Override
//    default Iterator<SmartEntity> iterator() {
//        return toCollection().iterator();
//    }
    Collection<SmartEntity> getChildren();
//    {
//        return Collections.emptyList();
//    }
//    default Collection<SmartEntity> toCollection() {
//        List<SmartEntity> ret = new ArrayList<>();
//
//        ret.add(this);
//        for (SmartEntity child : getChildren()) {
//            ret.addAll(child.toCollection());
//        }
//
//        return ret;
//    }

    //todo: check
    default <T extends SmartEntity> T getChild(String id, Class<T> cz) {
        if(this.getId().equals(id) && cz.isInstance(this)) {
            return (T)this;
        }

        for (SmartEntity child : this.getChildren()) {
            T x = child.getChild(id, cz);

            if(x != null) {
                return x;
            }
        }

        return null;
    }
}
