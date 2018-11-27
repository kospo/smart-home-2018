package me.kospo.smarthome.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.Application;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeStorage implements SmartHomeStorage {
    private static final Gson gsonRead = new Gson();
    private static final Gson gsonWrite = new GsonBuilder().setPrettyPrinting().create();
    public static final String fileStr = "./smart-home-1.js";

    @Override
    public SmartHome loadSmartHome() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileStr)));

        return gsonRead.fromJson(json, SmartHome.class);
    }

    @Override
    public void saveSmartHome() throws IOException {
        String jsonString = gsonWrite.toJson(Application.getSmartHome());
        System.out.println(jsonString);
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileStr))) {
            writer.write(jsonString);
        }
    }
}
