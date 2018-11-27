package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoryKeepingRemoteControl /*extends RemoteControlImpl*/ implements RemoteControl {
    private final Deque<RevertibleAction> history = new ArrayDeque<>();
    private final RemoteControl handler;

    public HistoryKeepingRemoteControl(RemoteControl remoteControl) {
//        super(remoteControl.getId());

        handler = remoteControl;
    }

    @Override
    public SmartAction getBind(RemoteControlButton button) {
        return handler.getBind(button);
    }

    @Override
    public SmartAction bind(RemoteControlButton button, SmartAction command) {
        return handler.bind(button, command);
    }

    @Override
    public SmartAction unbind(RemoteControlButton button) {
        return handler.unbind(button);
    }

    @Override
    public String getId() {
        return handler.getId();
    }

    @Override
    public void onButtonPressed(RemoteControlButton button) {
        handler.onButtonPressed(button);

        SmartAction action = handler.getBind(button);
        if(action != null) {
            if(action instanceof RevertibleAction) {
                history.addLast((RevertibleAction) action);
            }
        }
    }

    //todo: this is hacky
    public boolean undoLastAction() {
        RevertibleAction lastAction = history.peekLast();
        if(lastAction != null) {
            lastAction.unperform();
            history.removeLast();

            return true;
        }

        return false;
    }
}
