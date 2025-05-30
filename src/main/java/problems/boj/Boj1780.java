package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1780 {
    static int[][] paper;
    static int minusOnePaper, zeroPaper, onePaper;

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
        bw.write(Integer.toString(minusOnePaper) + '\n');
        bw.write(Integer.toString(zeroPaper) + '\n');
        bw.write(Integer.toString(onePaper));

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int n, int si, int sj) {
        if (n < 1) return;

        int num = paper[si][sj];
        for (int i = si; i < n + si; i++) {
            for (int j = sj; j < n + sj; j++) {
                if (num != paper[i][j]) {
                    int size = n / 3;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            recursion(size, si + size * x, sj + size * y);
                        }
                    }
                    return;
                }
            }
        }

        switch (num) {
            case -1:
                minusOnePaper++;
                break;
            case 0:
                zeroPaper++;
                break;
            case 1:
                onePaper++;
                break;
        }
    }
}