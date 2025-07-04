package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2293 {
    static int[] coins;
    static int n, k;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        coins = new int[n];
        k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1]; // k 금액을 만들 수 있는 경우의 수
        dp[0] = 1; // 동전을 0원으로 만드는 경우 1가지, 동전을 아무것도 사용하지 않은 경우

        for (int coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }

        bw.write(Integer.toString(dp[k]));

        br.close();
        bw.flush();
        bw.close();
    }

}