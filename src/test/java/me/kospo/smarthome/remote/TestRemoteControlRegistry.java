package me.kospo.smarthome.remote;

import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import com.coolcompany.smarthome.remote.RemoteControlRegistry;
import me.kospo.smarthome.CountingElement;
import me.kospo.smarthome.action.SmartAction;
import org.junit.Test;

import java.util.Map;

import static me.kospo.smarthome.remote.TestRemoteControl.REMOTE_ID;
import static org.junit.Assert.assertEquals;

public class TestRemoteControlRegistry {
    public static class CountingRemoteControlRegistry extends RemoteControlRegistryImpl implements CountingElement, RemoteControlRegistry {
        private int counter = 0;

        public Map<String, RemoteControl> getRegistry() {
            return registry;
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
    public void testRegistry() {
        CountingRemoteControlRegistry registry = new CountingRemoteControlRegistry();
        assertEquals(registry.getRegistry().size(), 0);

        TestRemoteControl.CountingRemoteControlImpl control = new TestRemoteControl.CountingRemoteControlImpl(REMOTE_ID);

        registry.registerRemoteControl(control, control.getId());
        assertEquals(registry.getRegistry().size(), 1);

        registry.registerRemoteControl(control, control.getId());
        assertEquals(registry.getRegistry().size(), 1);

        registry.onButtonPressed(control.getId(), RemoteControlButton.A);
        assertEquals(control.getCounter(), 0);

        control.bind(RemoteControlButton.A, new SmartAction(control::incrementCounter));

        registry.onButtonPressed(control.getId(), RemoteControlButton.A);
        assertEquals(control.getCounter(), 1);
    }
}
