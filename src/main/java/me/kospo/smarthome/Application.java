package me.kospo.smarthome;

import com.coolcompany.smarthome.events.SensorEventsManager;
import me.kospo.smarthome.event.HomeEventsObserver;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Application {
//    private static SmartHomeStorage smartHomeStorage = new FileSmartHomeStorage();
    private static SmartHome smartHome;
    private static HomeEventsObserver observer;
    //    private static HomeEventsObserver homeEventsObserver;

//    public static void setSmartHomeStorage(SmartHomeStorage smartHomeStorage) {
//        Application.smartHomeStorage = smartHomeStorage;
//    }

    public static SmartHome getSmartHome() {
        return smartHome;
    }

//    public static void main(String[] args) throws IOException {
//        smartHome = smartHomeStorage.loadSmartHome();
//        homeEventsObserver = new HomeEventsObserver(smartHome);
//        homeEventsObserver.runEventsCycle();
//    }

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(SmartConfiguration.class);
        smartHome = context.getBean(SmartHome.class);
        observer = context.getBean(HomeEventsObserver.class);
        observer.runEventsCycle();
//        SensorEventsManager sensorEventsManager = context.getBean(SensorEventsManager.class);
//        sensorEventsManager.start();
    }
}
