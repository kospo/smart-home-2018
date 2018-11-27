package me.kospo.smarthome.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.entity.Door;
import me.kospo.smarthome.entity.House;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.storage.FileSmartHomeStorage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Room kitchen = new Room(
                "kitchen",
                Arrays.asList(
                        new Light("1", false),
                        new Light("2", true)
                ),
                Arrays.asList(
                        new Door("1", false)
                ));
        Room bathroom = new Room(
                "bathroom",
                Arrays.asList(
                        new Light("3", true)
                ),
                Arrays.asList(
                        new Door("2", false)
                ));
        Room bedroom = new Room(
                "bedroom",
                Arrays.asList(
                        new Light("4", false),
                        new Light("5", false),
                        new Light("6", false)
                ),
                Arrays.asList(
                        new Door("3", true)
                ));
        Room hall = new Room(
                "hall",
                Arrays.asList(
                        new Light("7", false),
                        new Light("8", false),
                        new Light("9", false)
                ),
                Arrays.asList(
                        new Door("4", false)
                )
        );
        House mansion = new House("mansion", Arrays.asList(kitchen, bathroom, bedroom, hall));

        System.out.println(mansion);

        SmartHome smartHome = new SmartHome(mansion);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson(smartHome);
//        System.out.println(jsonString);

//        System.out.println("START");
//        for (SmartEntity smartEntity : smartHome.getResidence()) {
//            System.out.println(smartEntity);
//        }
//        System.out.println("END");

        Path path = Paths.get(FileSmartHomeStorage.fileStr);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }

}
