package com.essri.algorithm;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int startValue;
        int indexValue;
        int max;

        Stack<Integer> stack = new Stack<>();
        Queue<Integer> valueQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();

        for(int i = 0; i < priorities.length; i++) {
            stack.add(priorities[i]);
            valueQueue.offer(priorities[i]);
            indexQueue.offer(i);
        }

        Collections.sort(stack);

        while(true) {
            startValue = valueQueue.remove();
            indexValue = indexQueue.remove();
            max = stack.peek();
            if(startValue == max) {
                stack.pop();
                answer++;
                if(location == indexValue) {
                    break;
                }
            } else if(startValue < max) {
                valueQueue.offer(startValue);
                indexQueue.offer(indexValue);
            }
        }

        return answer;
    }
}
