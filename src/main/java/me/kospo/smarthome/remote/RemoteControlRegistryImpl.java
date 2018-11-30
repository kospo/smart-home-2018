package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import com.coolcompany.smarthome.remote.RemoteControlRegistry;

import java.util.HashMap;
import java.util.Map;

public class RemoteControlRegistryImpl implements RemoteControlRegistry {
    protected final Map<String, RemoteControl> registry = new HashMap<>();

    @Override
    public void registerRemoteControl(RemoteControl remoteControl, String rcId) {
        assert remoteControl.getId().equals(rcId);

        registry.put(rcId, remoteControl);
    }

    @Override
    public void onButtonPressed(String rcId, RemoteControlButton remoteControlButton) {
        RemoteControl remoteControl = registry.get(rcId);
        assert remoteControl != null;

        remoteControl.onButtonPressed(remoteControlButton);
    }

//    public void unregisterRemoteControl(String rcId) {
//        registry.remove(rcId);
//    }
}
