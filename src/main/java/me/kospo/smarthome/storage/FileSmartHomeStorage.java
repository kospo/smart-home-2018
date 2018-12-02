package me.kospo.smarthome.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.kospo.smarthome.SmartHome;
import me.kospo.smarthome.Application;
import me.kospo.smarthome.entity.House;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeStorage implements SmartHomeStorage {
    private static final Gson gsonRead = new Gson();
    private static final Gson gsonWrite = new GsonBuilder().setPrettyPrinting().create();
    public final String fileStr;

    public FileSmartHomeStorage(String fileStr) {
        this.fileStr = fileStr;
    }

    @Override
    public SmartHome loadSmartHome() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileStr)));

        House house = gsonRead.fromJson(json, House.class);

        return new SmartHome(house);
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
