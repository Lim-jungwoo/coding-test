package problems.boj;

import java.io.*;

public class Boj2156 {
    static int[] dp;
    static int[] drinks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        drinks = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = drinks[1];
        if (n > 1) {
            dp[2] = drinks[1] + drinks[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + drinks[i], dp[i - 3] + drinks[i - 1] + drinks[i]));
        }
        int result = dp[n];
        bw.write(Integer.toString(result));


        bw.flush();
        bw.close();
        br.close();
    }

}
