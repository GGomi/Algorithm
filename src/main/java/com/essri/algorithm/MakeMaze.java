package com.essri.algorithm;

import java.io.*;

public class MakeMaze {
    /*
     *  BOJ 1347
     */
    private int size;
    private String pattern;
    private int[][] base = new int[100][100];

    public MakeMaze(int size, String pattern) {
        this.size = size;
        this.pattern = pattern;
    }

    public void solve() throws IOException {
        BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));
        int[][] direction = {{1,0},{0,-1},{-1,0},{0,1}};
        int nowDirection = 0;
        int row = 49;
        int col = 49;
        int maxRow = 49;
        int maxCol = 49;
        int minRow = 49;
        int minCol = 49;

        base[row][col] = 1;
        for (int i = 0; i < size; i++) {
            char flag = pattern.charAt(i);

            switch (flag) {
                case 'F':
                    row = row + direction[nowDirection][0];
                    col = col + direction[nowDirection][1];
                    base[row][col] = 1;
                    break;
                case 'L':
                    if(nowDirection > 0)
                        nowDirection--;
                    else
                        nowDirection = 3;
                    break;
                case 'R':
                    if(nowDirection == 3)
                        nowDirection = 0;
                    else
                        nowDirection++;
                    break;
            }

            if(minRow > row) {
                minRow = row;
            }

            if(maxRow < row) {
                maxRow = row;
            }

            if(minCol > col) {
                minCol = col;
            }

            if(maxCol < col) {
                maxCol = col;
            }
        }

        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minCol; j <= maxCol; j++) {
                if(base[i][j] == 1)
                    bw.write('.');
                else
                    bw.write('#');
            }
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }
}

class MakeMazeMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MakeMaze makeMaze = new MakeMaze(Integer.parseInt(br.readLine()),br.readLine());
        makeMaze.solve();
    }
}
