package com.essri.algorithm;

import java.util.ArrayList;
import java.util.List;

public class BigNumber {
    public String solution(int[] numbers) {
        String answer = "";
        List<String> list = new ArrayList<>();
        int length = numbers.length;

        for(int i=0; i<length; i++){
            list.add(String.valueOf(numbers[i]));
        }

        list.sort((num1, num2) -> (num2 + num1).compareTo(num1 + num2));

        if(list.get(0).equals("0")){
            return "0";
        }

        for(String a:list) {
            answer = answer + a;
        }

        return answer;
    }
}
