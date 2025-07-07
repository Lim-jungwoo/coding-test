package problems.boj;

import java.io.*;
import java.util.*;

public class Boj7579 {
    static int N, M;
    static int[] m;
    static int[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        m = new int[N];
        c = new int[N];
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        int maxCost = Arrays.stream(c).sum(); // 비용 총합
        int[] dp = new int[maxCost + 1]; // dp[j] : j 비용으로 확보 가능한 최대 메모리

        // DP 진행
        for (int i = 0; i < N; i++) {
            for (int j = maxCost; j >= c[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - c[i]] + m[i]);
            }
        }

        // 최소 비용 찾기
        int answer = maxCost;
        for (int j = 0; j <= maxCost; j++) {
            if (dp[j] >= M) {
                answer = j;
                break;
            }
        }

        bw.write(Integer.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}