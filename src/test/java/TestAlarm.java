import org.junit.Test;
import ru.sbt.mipt.oop.model.alarm.Alarm;
import ru.sbt.mipt.oop.model.alarm.AlarmStateArmed;
import ru.sbt.mipt.oop.model.alarm.AlarmStateOff;
import ru.sbt.mipt.oop.model.alarm.AlarmStateTriggered;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlarm {
    public static final int CODE = 123;

    @Test
    public void testOff() {
        Alarm a = new Alarm(CODE);

        assertTrue(a.getState() instanceof AlarmStateOff);
        assertFalse(a.trigger());
        assertTrue(a.getState() instanceof AlarmStateOff);
        assertFalse(a.activate(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateOff);
        assertTrue(a.activate(CODE));
        assertTrue(a.getState() instanceof AlarmStateArmed);
    }

    @Test
    public void testOn() {
        Alarm a = new Alarm(CODE);

        assertTrue(a.getState() instanceof AlarmStateOff);
        assertTrue(a.activate(CODE));
        assertTrue(a.getState() instanceof AlarmStateArmed);
        assertFalse(a.deactivate(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateTriggered);
        assertFalse(a.deactivate(CODE + 1));
        assertTrue(a.getState() instanceof AlarmStateTriggered);
        assertTrue(a.deactivate(CODE));
        assertTrue(a.getState() instanceof AlarmStateOff);
    }
}
