package com.essri.algorithm;

import java.util.HashSet;
import java.util.Stack;

public class SixShop {
    static String[] braces(String[] values) {
        String[] answer = new String[values.length];
        for (int i = 0; i < values.length; i++) {
            Stack<Character> st = new Stack<>();
            char[] charArr = values[i].toCharArray();
            int j;

            for (j = 0; j < values[i].length(); j++) {
                if (charArr[j] == '(' || charArr[j] == '{' || charArr[j] == '[') {
                    st.push(charArr[j]);
                } else {
                    if (st.size() > 0) {
                        if (Math.abs(st.pop() - charArr[j]) > 2) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }

            if (st.size() == 0 && values[i].length() == j) {
                answer[i] = "YES";
            } else {
                answer[i] = "NO";
            }
        }
        return answer;

    }

    private static String isPangram(String[] inputs) {

        char[] alphabets = new char[26];

        StringBuilder answerBuilder = new StringBuilder();

        for (String input : inputs) {
            HashSet<Character> inputSet = new HashSet<>();

            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c == ' ') continue;
                if (!Character.isAlphabetic(c)) {
                    throw new IllegalArgumentException();
                }

                inputSet.add(c);
            }

            if (inputSet.size() == 26) {
                answerBuilder.append("1");
            } else {
                answerBuilder.append("0");
            }
        }

        return answerBuilder.toString();
    }

}
