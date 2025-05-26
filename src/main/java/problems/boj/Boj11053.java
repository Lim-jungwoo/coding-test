package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int result = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] < A[j])
                    dp[j] = Math.max(dp[j], dp[i] + 1);
            }
            result = Math.max(result, dp[i]);
        }

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }

}
