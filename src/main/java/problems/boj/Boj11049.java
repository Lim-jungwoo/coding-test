package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N + 1][2];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            matrix[i][0] = Integer.parseInt(st.nextToken());
            matrix[i][1] = Integer.parseInt(st.nextToken());

        }

        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N - len + 1; i++) {
                int j = len + i - 1;

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] +
                            matrix[i][0] * matrix[k][1] * matrix[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        int result = dp[1][N];
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }
}