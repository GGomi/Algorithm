package com.essri.algorithm;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bakery {
    /*
     * BOJ 3109
     */
    private int[][] map;
    private int row;
    private int column;
    private int resultPipe;

    public Bakery(int R, int C, BufferedReader br) throws IOException {
        this.row = R;
        this.column = C;
        resultPipe = 0;
        getData(br);
    }

    public void getData(BufferedReader br) throws IOException {
        map = new int[row][column];

        for (int i = 0; i < row; i++) {
            String rowInfo = br.readLine();

            for (int j = 0; j < column; j++) {

                if(rowInfo.charAt(j) == 'x') {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }
    }

    public void solve() {
        for (int i = 0; i < row; i++) {
            resultPipe += backTracking(i, 0);
        }
    }

    public int backTracking(int targetRow, int targetColumn) {
//        int[][] direction = {{-1, 1}, {0, 1}, {1, 1}}; // 오른쪽위, 오른쪽, 오른쪽아래 방향

        if (isSafe(targetRow, targetColumn)) {

            if (targetColumn >= column - 1) {
                return 1;
            }

            if (backTracking(targetRow - 1, targetColumn + 1) == 1) {
                return 1;
            }

            if (backTracking(targetRow, targetColumn + 1) == 1) {
                return 1;
            }

            if (backTracking(targetRow + 1, targetColumn + 1) == 1) {
                return 1;
            }
        }

        return 0;
    }

    public boolean isSafe(int targetRow, int targetColumn) {
        if(targetRow < 0 || targetRow >= row) {
            return false;
        }

        if(map[targetRow][targetColumn] != 0) {
            return false;
        }

        map[targetRow][targetColumn] = 1;

        return true;
    }

    public int getResultPipe() {
        return resultPipe;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Bakery bakery = new Bakery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), br);
        bakery.solve();
        System.out.println(bakery.getResultPipe());
    }
}
