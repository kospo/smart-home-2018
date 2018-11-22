import org.junit.Test;
import ru.sbt.mipt.oop.entity.alarm.Alarm;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateArmed;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateDisarmed;
import ru.sbt.mipt.oop.entity.alarm.state.AlarmStateTriggered;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlarm {
    private static final int CODE = 123;

    @Test
    public void testOff() {
        Alarm a = new Alarm(CODE);

        assertTrue(a.getState() instanceof AlarmStateDisarmed);
        assertFalse(a.trigger());
        assertTrue(a.getState() instanceof AlarmStateDisarmed);
        assertFalse(a.arm(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateDisarmed);
        assertTrue(a.arm(CODE));
        assertTrue(a.getState() instanceof AlarmStateArmed);
    }

    @Test
    public void testOn() {
        Alarm a = new Alarm(CODE);

        assertTrue(a.getState() instanceof AlarmStateDisarmed);
        assertTrue(a.arm(CODE));
        assertTrue(a.getState() instanceof AlarmStateArmed);
        assertFalse(a.disarm(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateTriggered);
        assertFalse(a.disarm(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateTriggered);
        assertTrue(a.disarm(CODE));
        assertTrue(a.getState() instanceof AlarmStateDisarmed);
    }
}
