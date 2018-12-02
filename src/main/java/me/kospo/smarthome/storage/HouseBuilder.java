package me.kospo.smarthome.storage;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kospo.smarthome.entity.Door;
import me.kospo.smarthome.entity.House;
import me.kospo.smarthome.entity.Light;
import me.kospo.smarthome.entity.Room;
import me.kospo.smarthome.entity.alarm.Alarm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HouseBuilder {

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
        Alarm alarm = new Alarm("alarm", 123);
        House mansion = new House("mansion", Arrays.asList(kitchen, bathroom, bedroom, hall), alarm);

        Gson gson = new GsonBuilder()
                .create();

        String jsonString = gson.toJson(mansion);
        System.out.println(jsonString);

        String fileStr = "./smart-home-1.js";
        Path path = Paths.get(fileStr);
        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(jsonString);
        }
    }
}
