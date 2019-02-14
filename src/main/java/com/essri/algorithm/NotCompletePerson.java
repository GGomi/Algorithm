package com.essri.algorithm;

import java.util.HashMap;
import java.util.Map;

public class NotCompletePerson {

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map1 = new HashMap<>();

        String answer = "";

//        for(String temp:participant) {
//            Integer value = map1.get(temp);
//            if(value == null) {
//                map1.put(temp,1);
//            } else {
//                map1.put(temp,value + 1);
//            }
//        }

        for(String partici:participant) {
            map1.put(partici,map1.getOrDefault(partici,0) + 1);
        }

        for(String complete:completion) {
            map1.put(complete,map1.get(complete) - 1);
        }

        for(String key:map1.keySet()) {
            if(map1.get(key) == 1) {
                answer = key;
            }
        }

        return answer;
    }


}
