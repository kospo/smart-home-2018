package ru.sbt.mipt.oop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.sbt.mipt.oop.model.*;
import ru.sbt.mipt.oop.storage.FileSmartHomeStorage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class HomeBuilder {

    public static void main(String[] args) throws IOException {
        Room kitchen = new Room(
                Arrays.asList(
                        new Light("1", false),
                        new Light("2", true)
                ),
                Arrays.asList(
                        new Door(false, "1")
                ),
                "kitchen");
        Room bathroom = new Room(
                Arrays.asList(
                        new Light("3", true)
                ),
                Arrays.asList(
                        new Door(false, "2")
                ),
                "bathroom");
        Room bedroom = new Room(
                Arrays.asList(
                        new Light("4", false),
                        new Light("5", false),
                        new Light("6", false)
                ),
                Arrays.asList(
                        new Door(true, "3")
                ),
                "bedroom");
        Room hall = new Room(
                Arrays.asList(
                        new Light("7", false),
                        new Light("8", false),
                        new Light("9", false)
                ),
                Arrays.asList(
                        new Door(false, "4")
                ), "hall"
        );
        House mansion = new House(Arrays.asList(kitchen, bathroom, bedroom, hall), "mansion");

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
