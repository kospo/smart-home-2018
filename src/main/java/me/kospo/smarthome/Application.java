package me.kospo.smarthome;

import me.kospo.smarthome.event.HomeEventsObserver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
    private static SmartHome smartHome;
    private static HomeEventsObserver observer;

    public static SmartHome getSmartHome() {
        return smartHome;
    }

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SmartConfiguration.class);
        smartHome = context.getBean(SmartHome.class);
        observer = context.getBean(HomeEventsObserver.class);
        observer.runEventsCycle();
    }
}
