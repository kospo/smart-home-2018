package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.action.impl.UndoLastRemoteAction;
import org.junit.Test;

import static me.kospo.smarthome.remote.TestRemoteControl.REMOTE_ID;
import static org.junit.Assert.assertEquals;

public class TestHistoryKeepingRemoteControl {
    public static class CountingHistoryKeepingRemoteControl extends HistoryKeepingRemoteControl implements CountingRemoteControl {
        private int counter = 0;

        public CountingHistoryKeepingRemoteControl(RemoteControl remoteControl) {
            super(remoteControl);
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

    @Test
    public void testHistoryKeepingRemoteControl() {
        RemoteControlImpl handlerRemoteControl = new RemoteControlImpl(REMOTE_ID);
        CountingHistoryKeepingRemoteControl control = new CountingHistoryKeepingRemoteControl(handlerRemoteControl);
        TestRemoteControl.testRemoteControl(control);

        control.bind(RemoteControlButton.A, new SmartAction(control::incrementCounter));
        control.bind(RemoteControlButton.B, new RevertibleAction(control::incrementCounter, control::decrementCounter));
        //todo: is this bad design?
        control.bind(RemoteControlButton.C, new UndoLastRemoteAction(control));

        int oldCounter = control.getCounter();
        control.onButtonPressed(RemoteControlButton.A);
        assertEquals(control.getCounter(), oldCounter + 1);

        oldCounter = control.getCounter();
        control.onButtonPressed(RemoteControlButton.B);
        assertEquals(control.getCounter(), oldCounter + 1);

        oldCounter = control.getCounter();
        control.onButtonPressed(RemoteControlButton.C);
        assertEquals(control.getCounter(), oldCounter - 1);

        oldCounter = control.getCounter();
        control.onButtonPressed(RemoteControlButton.C);
        assertEquals(control.getCounter(), oldCounter);
    }
}
