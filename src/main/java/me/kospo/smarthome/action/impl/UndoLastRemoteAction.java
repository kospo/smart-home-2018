package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.remote.AdvancedRemoteControl;

public class UndoLastRemoteAction extends SmartAction {
    public UndoLastRemoteAction(AdvancedRemoteControl remoteControl) {
        super(remoteControl::undoLastAction);
    }
}
