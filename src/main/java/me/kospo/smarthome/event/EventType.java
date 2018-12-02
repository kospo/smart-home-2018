package me.kospo.smarthome.event;

public enum EventType {
    //"LightIsOn", "LightIsOff", "DoorIsOpen", "DoorIsClosed", "DoorIsLocked", "DoorIsUnlocked"
    LIGHT_ON, LIGHT_OFF,
    DOOR_OPEN, DOOR_CLOSE, DOOR_LOCKED, DOOR_UNLOCK,
    ALARM_ARM, ALARM_DISARM, SIGNAL_FROM_REMOTE, ALARM_TRIGGER
}
