package com.essri.algorithm;

import java.util.*;

public class GiveupMath {
    public int[] solution(int[] answers) {
        int[] score = new int[3];
        LinkedList<Integer> answer = new LinkedList<>();
        int[] first = {1,2,3,4,5};
        int[] second = {2,1,2,3,2,4,2,5};
        int[] third = {3,3,1,1,2,2,4,4,5,5};
        int value;
        for(int i = 0; i < answers.length; i++) {
            if(first[i % 5] == answers[i]) score[0]++;
            if(second[i % 8] == answers[i]) score[1]++;
            if(third[i % 10] == answers[i]) score[2]++;
        }

        value = Math.max(score[0],Math.max(score[1],score[2]));

        for(int i = 0; i < 3; i++) {
            if(value == score[i]) answer.add(i+1);
        }

        int[] returns = new int[answer.size()];

        for(int i = 0; i < returns.length; i++) {
            returns[i] = answer.poll();
        }

        return returns;
    }
}
