package problems.boj;

import java.util.*;
import java.io.*;

public class Boj2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] wires = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            wires[i][0] = Integer.parseInt(st.nextToken());
            wires[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wires, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int lisLen = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (wires[i][1] < wires[j][1]) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            lisLen = Math.max(lisLen, dp[i]);
        }

        bw.write(Integer.toString(n - lisLen));

        bw.flush();
        bw.close();
        br.close();
    }
}
