import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.event.HomeEventsObserver;

public class TestHomeEventsObserver {
    @Test(expected = NullPointerException.class)
    public void testNull() {
        HomeEventsObserver.runEventsCycle(null);
    }
}
