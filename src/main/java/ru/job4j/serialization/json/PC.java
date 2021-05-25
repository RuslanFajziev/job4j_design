package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;

public class PC {
    private final boolean gamingPc;
    private final boolean waterColl;
    private final int guaranteePeriod;
    private final String brand;
    private final MB mb;
    private final String[] cpuType;

    public PC(boolean gamingPc, boolean waterColl, int guaranteePeriod, String brand, MB mb, String... cpuType) {
        this.gamingPc = gamingPc;
        this.waterColl = waterColl;
        this.guaranteePeriod = guaranteePeriod;
        this.brand = brand;
        this.cpuType = cpuType;
        this.mb = mb;
    }

    @Override
    public String toString() {
        return "PC{"
                + "gamingPc=" + gamingPc
                + ", waterColl=" + waterColl
                + ", guaranteePeriod=" + guaranteePeriod
                + ", brand='" + brand + '\''
                + ", mb=" + mb
                + ", cpuType=" + Arrays.toString(cpuType)
                + '}';
    }

    public static void main(String[] args) throws IOException {
        final PC pc = new PC(true, true, 36, "Sitylinke",
                new MB(false, 32, "LGA 2066"), "Pentium", "Celeron");
        System.out.println("---------------------");
        System.out.println(pc);
        System.out.println("---------------------");

        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(pc));
        System.out.println("---------------------");

        Path jsonFilePath = Path.of("./src/main/resources/pc.json");
//        File jsonFile = jsonFilePath.toFile();
//        if (!Files.exists(jsonFilePath)) {
//            jsonFile = Files.createFile(jsonFilePath).toFile();
//        }
        /* Преобразуем объект person в json файл. */
//        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(jsonFile)))) {
//            out.write(gson.toJson(pc));
//        }
        Files.write(jsonFilePath, Collections.singleton(gson.toJson(pc)));

        String in = Files.readString(jsonFilePath);
        /* Преобразуем json файл в объект person. */
        final PC pcFromJson = gson.fromJson(in, PC.class);
        System.out.println(pcFromJson);
        System.out.println("---------------------");
    }
}

class MB {
    private final boolean serverBoard;
    private final int maxRamSize;
    private final String socket;

    public MB(boolean serverBoard, int maxRamSize, String socket) {
        this.serverBoard = serverBoard;
        this.maxRamSize = maxRamSize;
        this.socket = socket;
    }

    @Override
    public String toString() {
        return "MB{"
                + "serverBoard=" + serverBoard
                + ", maxRamSize=" + maxRamSize
                + ", socket='" + socket + '\''
                + '}';
    }
}