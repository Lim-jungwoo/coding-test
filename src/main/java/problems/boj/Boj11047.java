package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        // 사용할 코인 중 값이 가장 큰 것
        int maxCoinIndex = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (K >= coins[i]) {
                maxCoinIndex = i;
                break;
            }
        }

        // 필요한 동전 개수
        int answer = 0;
        for (int i = maxCoinIndex; i >= 0; i--) {
            int coinCount = K / coins[i];
            K -= coins[i] * coinCount;
            answer += coinCount;
            if (K == 0) {
                break;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
        br.close();
    }
}