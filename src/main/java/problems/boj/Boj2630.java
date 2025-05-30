package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2630 {
    static int[][] paper;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        paper = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(N, 1, 1);
        bw.write(Integer.toString(white) + '\n');
        bw.write(Integer.toString(blue));

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int n, int si, int sj) {
        if (n < 1) return;

        int color = paper[si][sj];
        for (int i = si; i < si + n; i++) {
            for (int j = sj; j < sj + n; j++) {
                if (paper[i][j] != color) {
                    int size = n / 2;
                    recursion(size, si, sj);
                    recursion(size, si + size, sj);
                    recursion(size, si, sj + size);
                    recursion(size, si + size, sj + size);
                    return;
                }
            }
        }

        if (color == 1) blue++;
        else white++;
        return;
    }
}