package com.essri.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Coins {
    public static void main(String[] args) throws IOException {
        int T;
        int[] coinList;
        long[] count;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int exchange = Integer.parseInt(st.nextToken());
            int coinCount = Integer.parseInt(st.nextToken());
            count = new long[exchange + 1];

            String[] temp = br.readLine().split(" ");
            coinList = Arrays.stream(temp).mapToInt(Integer::parseInt).toArray();

            count[0] = 1;

            for(int i = 0; i < coinCount; i++) {
                for(int value = coinList[i]; value <= exchange; value+=coinList[0]) {
                    count[value] += count[value - coinList[i]];
                }
            }
            if(count[exchange] > 1000000007) {
                count[exchange] %= 1000000007;
            }
            System.out.println(count[exchange]);

            T--;
        }
    }
}
