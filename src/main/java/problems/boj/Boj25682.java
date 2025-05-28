package problems.boj;

import java.io.*;
import java.util.*;

public class Boj25682 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int n = 0; n < N; n++) {
            String line = br.readLine();
            for (int m = 0; m < M; m++) {
                board[n][m] = line.charAt(m);
            }
        }

        // 완벽한 white, black 체스판
        char[][] wBoard = new char[N][M];
        char[][] bBoard = new char[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if ((n + m) % 2 == 0) {
                    wBoard[n][m] = 'W';
                    bBoard[n][m] = 'B';
                }
                else {
                    wBoard[n][m] = 'B';
                    bBoard[n][m] = 'W';
                }
            }
        }

        // 완벽한 체스판과 보드의 다른 점 저장
        int[][] diffW = new int[N][M];
        int[][] diffB = new int[N][M];
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (wBoard[n][m] != board[n][m]) {
                    diffW[n][m] = 1;
                }
                if (bBoard[n][m] != board[n][m]) {
                    diffB[n][m] = 1;
                }
            }
        }

        // 다른 점 누적합
        int[][] prefixW = new int[N + 1][M + 1];
        int[][] prefixB = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                prefixW[n][m] = prefixW[n - 1][m] + prefixW[n][m - 1]
                        - prefixW[n - 1][m - 1] + diffW[n - 1][m - 1];
                prefixB[n][m] = prefixB[n - 1][m] + prefixB[n][m - 1]
                        - prefixB[n - 1][m - 1] + diffB[n - 1][m - 1];
            }
        }

        // 최소값
        int min = Integer.MAX_VALUE;
        for (int n = K; n <= N; n++) {
            for (int m = K; m <= M; m++) {
                int valueW = prefixW[n][m] - prefixW[n - K][m]
                        - prefixW[n][m - K] + prefixW[n - K][m - K];
                int valueB = prefixB[n][m] - prefixB[n - K][m]
                        - prefixB[n][m - K] + prefixB[n - K][m - K];
                min = Math.min(min, Math.min(valueW, valueB));
            }
        }

        bw.write(Integer.toString(min));

        bw.flush();
        bw.close();
        br.close();
    }
}
