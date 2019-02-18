package com.essri.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SoccerGame {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] temp = new int[10001];
    int[] scoreArray;
    int length;

    public SoccerGame(int length, int[] scoreArray) {
        this.length = length;
        this.scoreArray = scoreArray;
    }

    public static void main(String[] args) throws IOException {
        int team = Integer.parseInt(br.readLine());
        int[] array = new int[team];
        int count = 0;

        for(String temp:br.readLine().split(" ")) {
            array[count] = Integer.parseInt(temp);
            count++;
        }

//        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray() => 이거사용하면 거의 2배 더 걸림
        SoccerGame soccerGame = new SoccerGame(team, array);
        System.out.println(soccerGame.solution());
    }

    public int solution() {
        Arrays.sort(scoreArray);
        int sum = 0;
        int lose = 0;
        int check;

        for(int i = 0; i < length; i++) {
            sum += scoreArray[i];
            lose += length -1 -scoreArray[length-1-i];
            check = (i+1)*i/2;
            if(sum < check|| lose < check) return -1;
        }

        return sum == length*(length-1)/2 ? 1:-1;
    }
}
