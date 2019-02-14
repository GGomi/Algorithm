package com.essri.algorithm;

import java.util.Stack;

public class SteelStick {
    public int solution(String arrangement) {
        int answer = 0;

        arrangement = arrangement.replace("()","0");
        Stack stack = new Stack();
        char character;

        for(int i = 0; i < arrangement.length(); i++) {
            character = arrangement.charAt(i);
            if(character == '(') {
                stack.push(character);
            } else if(character == ')') {
                stack.pop();
                answer += 1;
            } else if(character == '0') {
                answer += stack.size();
            }
        }

        return answer;
    }
}
