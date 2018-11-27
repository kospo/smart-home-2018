package me.kospo.smarthome.action.impl;

import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.remote.HistoryKeepingRemoteControl;

public class UndoLastRemoteAction extends SmartAction {
    public UndoLastRemoteAction(HistoryKeepingRemoteControl remoteControl) {
        super(remoteControl::undoLastAction);
    }
}
