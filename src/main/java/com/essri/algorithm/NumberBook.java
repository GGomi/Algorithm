package com.essri.algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class NumberBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));

        for(int i = 0; i < phone_book.length; i++) {
            String temp = phone_book[i];
            for(int j = i+1; j < phone_book.length; j++) {
                if(phone_book[j].startsWith(temp)) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }
}
