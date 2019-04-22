package com.essri.algorithm;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2476 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int cycle = Integer.parseInt(br.readLine());
        int MAX = -1;

        for (int i = 0; i < cycle; i++) {
            int[] temp = new int[3];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < 3; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(temp);

            int res = calc(temp);

            if(MAX < res) MAX = res;
        }

        System.out.println(MAX);

    }

    private static int calc(int[] arr) {
        int temp = arr[0];
        int count = 0;

        for (int i = 1; i < 3; i++) {
            if(arr[i] == temp) count++;
            else temp = arr[i];
        }

        if(count == 0) {
            return arr[2]*100;
        } else if(count == 1) {
            return (temp * 100) + 1000;
        } else {
            return (temp * 1000) + 10000;
        }
    }

}
