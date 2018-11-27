package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;

import java.util.HashMap;
import java.util.Map;

public class RemoteControlImpl implements RemoteControl {
    private final String id;
    private final Map<RemoteControlButton, SmartAction> binds = new HashMap<>();

    public RemoteControlImpl(String id) {
        this.id = id;
    }

    @Override
    public SmartAction getBind(RemoteControlButton button) {
        return binds.get(button);
    }

    @Override
    public SmartAction bind(RemoteControlButton button, SmartAction command) {
        return binds.put(button, command);
    }

    @Override
    public SmartAction unbind(RemoteControlButton button) {
        return binds.remove(button);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void onButtonPressed(RemoteControlButton button) {
        SmartAction action = binds.get(button);

        if(action != null) {
            action.perform();
        }
    }
}
