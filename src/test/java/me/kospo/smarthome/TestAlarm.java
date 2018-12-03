package me.kospo.smarthome;

import org.junit.Test;
import me.kospo.smarthome.entity.alarm.Alarm;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestAlarm {
    private static final int CODE = 123;

    @Test
    public void testOff() {
        Alarm a = new Alarm(Alarm.MAIN_ALARM_ID, CODE);

        assertTrue(a.isDisarmed());
        a.trigger();
        assertTrue(a.isDisarmed());
        a.arm(CODE + 1);
        assertTrue(a.isDisarmed());
        a.arm(CODE);
        assertTrue(a.isArmed());
    }

    @Test
    public void testOn() {
        Alarm a = new Alarm(Alarm.MAIN_ALARM_ID, CODE);

        assertTrue(a.isDisarmed());
        a.arm(CODE);
        assertTrue(a.isArmed());
        a.disarm(CODE + 1);
        assertTrue(a.isTriggered());
        a.disarm(CODE + 1);
        assertTrue(a.isTriggered());
        a.disarm(CODE);
        assertTrue(a.isDisarmed());
    }
}
