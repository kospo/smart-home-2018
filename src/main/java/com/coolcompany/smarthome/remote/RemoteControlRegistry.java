package com.coolcompany.smarthome.remote;

public interface RemoteControlRegistry {
    //todo: remove rcId?
    void registerRemoteControl(RemoteControl remoteControl, String rcId);

    //api fix
    void onButtonPressed(String rcId, RemoteControlButton remoteControlButton);
}
