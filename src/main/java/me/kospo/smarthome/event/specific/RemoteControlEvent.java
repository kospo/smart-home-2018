package me.kospo.smarthome.event.specific;

import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.event.Event;
import me.kospo.smarthome.event.EventType;

public class RemoteControlEvent extends SensorEvent implements Event {
    private final RemoteControlButton button;

    public RemoteControlEvent(String rcId, RemoteControlButton button) {
        super(EventType.SIGNAL_FROM_REMOTE, rcId);

        this.button = button;
    }

    public RemoteControlButton getButton() {
        return button;
    }
}
