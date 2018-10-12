package ru.sbt.mipt.oop.model;

import java.util.*;

public interface SmartEntity extends Iterable<SmartEntity> {
    default Collection<SmartEntity> getChildren() {
        return Collections.emptyList();
    }

    SmartEntity getParent();

    @Override
    default Iterator<SmartEntity> iterator() {
        return toCollection().iterator();
//        return new SmartEntityIterator(this);
    }

    default Collection<SmartEntity> toCollection() {
        List<SmartEntity> ret = new ArrayList<>();

        ret.add(this);
        for (SmartEntity child : getChildren()) {
            ret.addAll(child.toCollection());
        }

        return ret;
    }
}
