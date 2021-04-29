package ru.job4j.baseemails;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapUserEmail {
    public static Map<String, Set<String>> merge(Map<String, Set<String>> account) {
        Map<String, Set<String>> in = new HashMap<>(account);
        Map<String, Set<String>> out = new HashMap<>();
        for (Map.Entry<String, Set<String>> inElement : in.entrySet()) {
            String keyIn = inElement.getKey();
            Set<String> valueIn = inElement.getValue();
            if (out.isEmpty()) {
                out.put(keyIn, valueIn);
                continue;
            }
            for (Map.Entry<String, Set<String>> outElement : out.entrySet()) {
                String keyOut = outElement.getKey();
                Set<String> valueOut = outElement.getValue();
                if (diff(valueIn, valueOut)) {
                    valueOut.addAll(valueIn);
                    out.put(keyOut, valueOut);
                } else {
                    out.put(keyIn, valueIn);
                    continue;
                }
            }
        }
        return out;
    }

    public static boolean diff(Set<String> leftSet, Set<String> rightSet) {
        for (var elm : leftSet) {
            if (rightSet.contains(elm)) {
                return true;
            }
        }
        return false;
    }
}