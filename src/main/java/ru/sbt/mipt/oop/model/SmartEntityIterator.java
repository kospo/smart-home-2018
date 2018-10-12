//package ru.sbt.mipt.oop.model;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Iterator;
//
//public class SmartEntityIterator implements Iterator<SmartEntity> {
//    private final SmartEntity entity;
//
//    private Collection<SmartEntity> collection;
//    private Iterator<SmartEntity> collectionIterator;
//
//    private Collection<SmartEntity> parent;
//    private Iterator<SmartEntity> parentIterator;
//
//    public SmartEntityIterator(SmartEntity entity) {
//        this.entity = entity;
//
//        collection = Arrays.asList(entity);
//        collectionIterator = collection.iterator();
//    }
//
//    @Override
//    public boolean hasNext() {
//        if(!collectionIterator.hasNext()) {
////            SmartEntity par = findNextParent();
//            for (SmartEntity trialParent : collection) {
//                Collection<SmartEntity> trialChildren = trialParent.getChildren();
//                if (!trialChildren.isEmpty()) {
//                    collection = trialChildren;
//                    collectionIterator = collection.iterator();
//
//                    if(!collectionIterator.hasNext()) {
//
//                    }
//                }
//            }
//
//            return false;
//        }
//
//        return collectionIterator.hasNext();
//    }
//
//    @Override
//    public SmartEntity next() {
//        return collectionIterator.next();
//    }
//
//    public SmartEntity getEntity() {
//        return entity;
//    }
//}
