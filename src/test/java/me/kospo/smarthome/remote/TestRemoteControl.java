package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.action.impl.UndoLastRemoteAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRemoteControl {
    public static final String REMOTE_ID = "test_id";

    @Test
    public void testControl() {
        CountingRemoteControlImpl control = new CountingRemoteControlImpl(REMOTE_ID);
        assertEquals(control.getId(), REMOTE_ID);

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            assertNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            control.bind(btn, new SmartAction(control::incrementCounter));
            assertNotNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            int oldCounter = control.getCounter();
            control.onButtonPressed(btn);
            assertEquals(control.getCounter(), oldCounter + 1);
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            control.unbind(btn);
            assertNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            int oldCounter = control.getCounter();
            control.onButtonPressed(btn);
            assertEquals(control.getCounter(), oldCounter);
        }
    }

    @Test
    public void testHistory() {
        CountingRemoteControlImpl control = new CountingRemoteControlImpl(REMOTE_ID);

        control.bind(RemoteControlButton.A, new SmartAction(control::incrementCounter));
        control.bind(RemoteControlButton.B, new RevertibleAction(control::incrementCounter, control::decrementCounter));
        control.bind(RemoteControlButton.C, new UndoLastRemoteAction(control));

        control.onButtonPressed(RemoteControlButton.A);
        assertEquals(control.getCounter(), 1);

        control.onButtonPressed(RemoteControlButton.B);
        assertEquals(control.getCounter(), 2);

        control.onButtonPressed(RemoteControlButton.C);
        assertEquals(control.getCounter(), 1);

        control.onButtonPressed(RemoteControlButton.C);
        assertEquals(control.getCounter(), 1);
    }

    public static class CountingRemoteControlImpl extends RemoteControlImpl implements CountingRemoteControl {
        private int counter = 0;

        public CountingRemoteControlImpl(String id) {
            super(id);
        }

        @Override
        public void incrementCounter() {
            counter++;
        }

        @Override
        public void decrementCounter() {
            counter--;
        }

        @Override
        public int getCounter() {
            return counter;
        }
    }
}
