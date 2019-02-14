package com.essri.algorithm;

import java.util.*;

public class Camouflage {

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> hm = new HashMap<>();

        for (String[] cloth : clothes) {
            hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
        }

        for(String key:hm.keySet()) {
            answer *= hm.get(key) + 1;
        }

        return answer-1;
    }
}
