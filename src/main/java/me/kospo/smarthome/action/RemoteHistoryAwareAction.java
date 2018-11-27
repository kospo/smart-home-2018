package me.kospo.smarthome.action;

import com.coolcompany.smarthome.remote.RemoteControl;
import me.kospo.smarthome.SmartHome;

import java.util.*;

public class RemoteHistoryAwareAction extends RevertibleAction {
    private final static Map<RemoteControl, Deque<RevertibleAction>> REMOTE_ACTION_HISTORY = new HashMap<>();

//    private final SmartAction handler;

    public RemoteHistoryAwareAction(final RemoteControl remoteControl, final RevertibleAction handlerAction) {
        super(() -> {
            handlerAction.perform();
            addToHistory(remoteControl, handlerAction);
        }, () -> {
            rmLastInHistory(remoteControl);
            handlerAction.unperform();
        });

        //todo?
//        this.handler = handlerAction;
    }

    private static void addToHistory(RemoteControl remoteControl, RevertibleAction handler) {
        Deque<RevertibleAction> curRemoteHistory = REMOTE_ACTION_HISTORY.getOrDefault(remoteControl, new ArrayDeque<>());
        curRemoteHistory.addLast(handler);
        REMOTE_ACTION_HISTORY.put(remoteControl, curRemoteHistory);
    }
    //todo: this is unsafe
    private static void rmLastInHistory(RemoteControl remoteControl) {
        REMOTE_ACTION_HISTORY.get(remoteControl).removeLast();
    }
    private static RevertibleAction getLastInHistory(RemoteControl remoteControl) {
        return REMOTE_ACTION_HISTORY.getOrDefault(remoteControl, new ArrayDeque<>()).peekLast();
    }
}
