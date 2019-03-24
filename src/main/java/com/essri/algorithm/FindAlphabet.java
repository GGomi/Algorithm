package com.essri.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindAlphabet {
    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            int index = input.charAt(i);
            if(alphabet[index-97] == -1) {
                alphabet[index-97] = i;
            }
        }

        for (int temp : alphabet) {
            System.out.print(temp + " ");
        }
    }
}
