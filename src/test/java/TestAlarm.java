import org.junit.Test;
import me.kospo.smarthome.entity.alarm.Alarm;
import me.kospo.smarthome.entity.alarm.state.AlarmStateArmed;
import me.kospo.smarthome.entity.alarm.state.AlarmStateDisarmed;
import me.kospo.smarthome.entity.alarm.state.AlarmStateTriggered;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlarm {
    private static final int CODE = 123;

    @Test
    public void testOff() {
        Alarm a = new Alarm(Alarm.MAIN_ALARM_ID, CODE);

        assertTrue(a.isDisarmed());
        assertFalse(a.trigger());
        assertTrue(a.isDisarmed());
        assertFalse(a.arm(CODE + 1));
        assertTrue(a.isDisarmed());
        assertTrue(a.arm(CODE));
        assertTrue(a.isArmed());
    }

    @Test
    public void testOn() {
        Alarm a = new Alarm(Alarm.MAIN_ALARM_ID, CODE);

        assertTrue(a.isDisarmed());
        assertTrue(a.arm(CODE));
        assertTrue(a.isArmed());
        assertFalse(a.disarm(CODE + 1));
        assertTrue(a.isTriggered());
        assertFalse(a.disarm(CODE + 1));
        assertTrue(a.isTriggered());
        assertTrue(a.disarm(CODE));
        assertTrue(a.isDisarmed());
    }
}
