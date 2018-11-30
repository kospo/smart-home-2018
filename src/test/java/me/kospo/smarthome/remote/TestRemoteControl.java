package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.action.impl.UndoLastRemoteAction;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRemoteControl {
    public static final String REMOTE_ID = "test_id";

    public static class CountingRemoteControlImpl extends RemoteControlImpl implements CountingRemoteControl {
        public int counter = 0;

        public CountingRemoteControlImpl(String id) {
            super(id);
        }

        @Override
        public void decrementCounter() {
            counter--;
        }

        @Override
        public void incrementCounter() {
            counter++;
        }

        @Override
        public int getCounter() {
            return counter;
        }
    }

    @Test
    public void testSimpleRemoteControl() {
        testRemoteControl(new CountingRemoteControlImpl(REMOTE_ID));
    }

    public static void testRemoteControl(CountingRemoteControl control) {
//        RemoteControl control = new RemoteControlImpl(REMOTE_ID);
//        assertEquals(control.getId(), REMOTE_ID);
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
}
