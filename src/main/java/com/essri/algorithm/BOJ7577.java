package com.essri.algorithm;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ7577 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new PrintWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[41][41];

        // init
        for (int i = 0; i <= l; i++) {
            for (int j = 0; j <= l; j++) {
                if (i != j)
                    graph[i][j] = 10000000;
            }
        }

        for (int i = 0; i < l; i++) {
            graph[i + 1][i] = 0;
            graph[i][i + 1] = 1;
        }

        for (int i = 0, x, y, z; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            z = Integer.parseInt(st.nextToken());

            if (graph[x - 1][y] > z) graph[x - 1][y] = z;
            graph[y][x - 1] = -z;
            
        }

        for (int i = 0; i <= l; i++)
            for (int j = 0; j <= l; j++)
                for (int k = 0; k <= l; k++)
                    if (graph[j][i] + graph[i][k]<graph[j][k]) graph[j][k] = graph[j][i] + graph[i][k];

        for(int i = 0; i <= l; i++) {
            if(graph[i][i] < 0) {
                System.out.println("NONE");
                return;
            }
        }

        for(int i = 0; i < l; i++) {
            System.out.println(graph[0][i+1]);
            System.out.println(graph[0][i]);
            bw.write(graph[0][i+1] - graph[0][i] != 0 ? '#':'-');
        }


        bw.flush();
        bw.close();
//        --#--####--#
    }


//    int l, n, w[41][41];
//    int main() {
//        scanf("%d %d", &l, &n);
//        for (int i = 0; i <= l; i++)
//            for (int j = 0; j <= l; j++) if (i != j) w[i][j] = 1e9;
//        for (int i = 0; i < l; i++) w[i + 1][i] = 0, w[i][i + 1] = 1;
//        for (int i = 0, x, y, z; i < n; i++) {
//            scanf("%d %d %d", &x, &y, &z);
//            if (w[x - 1][y]>z) w[x - 1][y] = z;
//            w[y][x - 1] = -z;
//        }
//        for (int i = 0; i <= l; i++)
//            for (int j = 0; j <= l; j++)
//                for (int k = 0; k <= l; k++)
//                    if (w[j][i] + w[i][k]<w[j][k]) w[j][k] = w[j][i] + w[i][k];
//        for (int i = 0; i <= l; i++) if (w[i][i] < 0) {
//            puts("NONE");
//            return 0;
//        }
//        for (int i = 0; i < l; i++) putchar(w[0][i + 1] - w[0][i] ? '#' : '-');
//        return 0;
//    }
}
