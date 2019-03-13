package com.essri.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        int T;
        int count = 0;
        T = Integer.parseInt(br.readLine());
        while (T > 0) {
            int set;
            set = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < set; i++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == i + 1) {
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
            T--;
        }
    }
}
