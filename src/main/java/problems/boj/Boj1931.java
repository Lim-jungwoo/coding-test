package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] conferences = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            conferences[i][0] = Integer.parseInt(st.nextToken());
            conferences[i][1] = Integer.parseInt(st.nextToken());
        }

        // 회의 끝나는 시간 기준 오름차순 정렬
        Arrays.sort(conferences, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]); // 종료 시간 같으면 시작 시간 빠른 순
            return Integer.compare(o1[1], o2[1]);
        });

        // 최대 회의 개수
        int[] dp = new int[N];
        dp[0] = 1;
        int minEnd = conferences[0][1];
        for (int i = 1; i < N; i++) {
            int start = conferences[i][0];
            if (start >= minEnd) {
                minEnd = conferences[i][1];
                dp[i] = dp[i - 1] + 1;
            }
            else {
                dp[i] = dp[i - 1];
            }
        }

        System.out.println(Integer.toString(dp[N - 1]));


        bw.flush();
        bw.close();
        br.close();
    }
}