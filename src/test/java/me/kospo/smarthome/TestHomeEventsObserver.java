package me.kospo.smarthome;

import org.junit.Test;
import me.kospo.smarthome.event.HomeEventsObserver;

public class TestHomeEventsObserver {
    @Test(expected = NullPointerException.class)
    public void testNull() {
//        HomeEventsObserver.runEventsCycle(null);
    }
}
