package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.SmartAction;

public interface AdvancedRemoteControl {
    String getId();

    SmartAction getBind(RemoteControlButton button);
    SmartAction bind(RemoteControlButton button, SmartAction command);
    SmartAction unbind(RemoteControlButton button);
}
