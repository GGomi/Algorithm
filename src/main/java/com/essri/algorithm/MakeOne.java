package com.essri.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
    public int input;
    public int[] mem = new int[1000001];

    public MakeOne(int input) {
        this.input = input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MakeOne makeOne = new MakeOne(Integer.parseInt(br.readLine()));
        System.out.println(makeOne.solution());
    }
    public int solution() {
        if(input == 1) {
            return 0;
        }

        mem[1] = 0;

        for(int i = 2; i <= input; i++) {
            mem[i] = mem[i-1] + 1;

            if(i % 2 == 0) {
                mem[i] = Math.min(mem[i], mem[i/2] + 1);
            }

            if(i % 3 == 0) {
                mem[i] = Math.min(mem[i], mem[i/3] + 1);
            }
        }

        return mem[input];
    }
}
