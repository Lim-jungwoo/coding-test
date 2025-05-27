package problems.boj;

import java.util.*;
import java.io.*;

public class Boj12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] weightValue = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weightValue[i][0] = Integer.parseInt(st.nextToken());
            weightValue[i][1] = Integer.parseInt(st.nextToken());
        }

        // 가치합 최대값 탐색
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int weight = weightValue[i - 1][0];
            int value = weightValue[i - 1][1];

            for (int w = 0; w <= K; w++) {
                if (w < weight) {
                    dp[i][w] = dp[i - 1][w];
                }
                else {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + value);
                }
            }
        }

        bw.write(Integer.toString(dp[N][K]));

        bw.flush();
        bw.close();
        br.close();
    }
}

