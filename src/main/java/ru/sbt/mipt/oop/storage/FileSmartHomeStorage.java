package ru.sbt.mipt.oop.storage;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.Application;
import ru.sbt.mipt.oop.SmartHomeStorage;
import ru.sbt.mipt.oop.model.SmartHome;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileSmartHomeStorage implements SmartHomeStorage {
    private static final Gson gson = new Gson();
    private static final String fileStr = "./smart-home-1.js";

    @Override
    public SmartHome loadSmartHome() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get(fileStr)));

        return gson.fromJson(json, SmartHome.class);
    }

    @Override
    public void saveSmartHome() throws IOException {
        FileWriter fw = new FileWriter(fileStr);
        gson.toJson(Application.getSmartHome(), fw);
    }
}
