package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TestJsonPC {
    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonMB = new JSONObject();
        jsonMB.put("serverBoard", false);
        jsonMB.put("maxRamSize", 32);
        jsonMB.put("socket", "LGA 2066");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Pentium");
        list.add("Celeron");
        JSONArray jsonCpuTypes = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final PC pc = new PC(true, true, 36, "Sitylinke",
                new MB(false, 32, "LGA 2066"), "Pentium", "Celeron");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gamingPc", pc.isGamingPc());
        jsonObject.put("waterColl", pc.isWaterColl());
        jsonObject.put("guaranteePeriod", pc.getGuaranteePeriod());
        jsonObject.put("brand", pc.getBrand());
        jsonObject.put("mb", jsonMB);
        jsonObject.put("cpuType", jsonCpuTypes);

        /* Выведем результат в консоль */
        System.out.println(jsonObject);

        /* Преобразуем объект pc в json-строку */
        System.out.println(new JSONObject(pc));
    }
}
