package me.kospo.smarthome;

import com.coolcompany.smarthome.remote.RemoteControlRegistry;
import me.kospo.smarthome.entity.SmartEntity;
import me.kospo.smarthome.remote.RemoteControlRegistryImpl;
import org.springframework.stereotype.Component;

//@Component
public class SmartHome {
    private final SmartEntity residence;
    private final RemoteControlRegistry remoteControlRegistry;

    public SmartHome(SmartEntity residence) {
        this.residence = residence;
        this.remoteControlRegistry = new RemoteControlRegistryImpl();
        //todo: fill parents
//        residence.fillParents();
    }

    public SmartEntity getResidence() {
        return residence;
    }

    public RemoteControlRegistry getRemoteControlRegistry() {
        return remoteControlRegistry;
    }
}
