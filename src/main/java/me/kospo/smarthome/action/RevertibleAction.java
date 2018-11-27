package me.kospo.smarthome.action;

public class RevertibleAction extends SmartAction {
    private final Runnable undoAction;

    public RevertibleAction(Runnable action, Runnable undoAction) {
        super(action);

        this.undoAction = undoAction;
    }

    public void unperform() {
        undoAction.run();
    }
}
