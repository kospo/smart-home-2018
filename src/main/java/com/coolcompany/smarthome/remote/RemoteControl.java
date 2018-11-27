package com.coolcompany.smarthome.remote;

import me.kospo.smarthome.action.SmartAction;

public interface RemoteControl {
    void onButtonPressed(RemoteControlButton button);
    //fix
    String getId();

    //cheats
    SmartAction getBind(RemoteControlButton button);
    SmartAction bind(RemoteControlButton button, SmartAction command);
    SmartAction unbind(RemoteControlButton button);
}
