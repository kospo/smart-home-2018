import com.coolcompany.smarthome.remote.RemoteControl;
import com.coolcompany.smarthome.remote.RemoteControlButton;
import me.kospo.smarthome.action.RevertibleAction;
import me.kospo.smarthome.action.SmartAction;
import me.kospo.smarthome.action.impl.UndoLastRemoteAction;
import me.kospo.smarthome.remote.HistoryKeepingRemoteControl;
import me.kospo.smarthome.remote.RemoteControlImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestRemote {
    public static final String REMOTE_ID = "test_id";
    public int counter = 0;

    @Test
    public void testRegistry() {
//        RemoteControlRegistry registry = new RemoteControlRegistryImpl();
//
//        registry.registerRemoteControl(control, control.getId());

    }

    @Test
    public void testHistoricRemoteControl() {
        HistoryKeepingRemoteControl control = new HistoryKeepingRemoteControl(new RemoteControlImpl(REMOTE_ID));
        testRemoteControl(control);

        control.bind(RemoteControlButton.A, new SmartAction(() -> {
            counter++;
        }));
        control.bind(RemoteControlButton.B, new RevertibleAction(
                () -> {
                    counter++;
                },
                () -> {
                    counter--;
                }
        ));
        //todo: this is bad design
        control.bind(RemoteControlButton.C, new UndoLastRemoteAction(control));

        control.onButtonPressed(RemoteControlButton.A);
    }

    @Test
    public void testSimpleRemoteControl() {
        testRemoteControl(new RemoteControlImpl(REMOTE_ID));
    }

    public void testRemoteControl(RemoteControl control) {
//        RemoteControl control = new RemoteControlImpl(REMOTE_ID);
//        assertEquals(control.getId(), REMOTE_ID);
        for (RemoteControlButton btn : RemoteControlButton.values()) {
            assertNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            control.bind(btn, new SmartAction(() -> {
                counter++;
            }));
            assertNotNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            int oldCounter = counter;
            control.onButtonPressed(btn);
            assertEquals(counter, oldCounter + 1);
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            control.unbind(btn);
            assertNull(control.getBind(btn));
        }

        for (RemoteControlButton btn : RemoteControlButton.values()) {
            int oldCounter = counter;
            control.onButtonPressed(btn);
            assertEquals(counter, oldCounter);
        }

    }
}
