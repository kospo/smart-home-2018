package me.kospo.smarthome.action;

public class SmartAction {
    private final Runnable action;

    public SmartAction(Runnable action) {
        this.action = action;
    }

    public void perform() {
        action.run();
    }
}
