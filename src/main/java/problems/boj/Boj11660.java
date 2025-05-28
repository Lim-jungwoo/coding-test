package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // Solution 1 -> O(M x N) => 최대 10⁸
        // 한 줄당 누적합 저장
//        int[][] dp = new int[N + 1][N + 1];
//        // 배열 저장
//        int[][] arr = new int[N + 1][N + 1];
//        for (int i = 1; i <= N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 1; j <= N; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                arr[i][j] = num;
//                dp[i][j] = dp[i][j - 1] + num;
//            }
//        }
//
//        // 결과, O(M x N) => 최대 10⁸
//        for (int i = 0; i < M; i++) {
//            st = new StringTokenizer(br.readLine());
//            int x1 = Integer.parseInt(st.nextToken());
//            int y1 = Integer.parseInt(st.nextToken());
//            int x2 = Integer.parseInt(st.nextToken());
//            int y2 = Integer.parseInt(st.nextToken());
//            int result = 0;
//
//            if (x1 == x2 && y1 == y2) {
//                result = arr[x1][y1];
//            }
//            else if (x1 == x2) {
//                result = dp[x1][y2] - dp[x1][y1 - 1];
//            }
//            else if (y1 == y2) {
//                for (int j = x1; j <= x2; j++) {
//                    result += arr[j][y1];
//                }
//            }
//            else {
//                for (int j = x1; j <= x2; j++) {
//                    result += dp[j][y2] - dp[j][y1 - 1];
//                }
//            }
//            bw.write(Integer.toString(result));
//            if (i != M - 1) {
//                bw.write('\n');
//            }
//        }

        // Solution 2 -> O(M x N) => 최대 10^6
        // (1,1) -> (x,y) 누적합 저장
        int[][] dp = new int[N + 1][N + 1];
        // 배열 저장
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                dp[i][j] = arr[i][j] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
            bw.write(Integer.toString(result));
            if (i != M - 1) {
                bw.write('\n');
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
