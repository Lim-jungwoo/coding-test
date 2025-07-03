package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2629 {
    static boolean[][] dp = new boolean[31][15001];
    static boolean[] possible = new boolean[15001];
    static int[] weightList;
    static int weightCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        weightCount = Integer.parseInt(st.nextToken());
        weightList = new int[weightCount];
        st = new StringTokenizer(br.readLine());
        for (int weightIndex = 0; weightIndex < weightCount; weightIndex++) {
            weightList[weightIndex] = Integer.parseInt(st.nextToken());
        }

        int beadCount = Integer.parseInt(br.readLine());
        int[] beadList = new int[beadCount];
        st = new StringTokenizer(br.readLine());
        for (int beadIndex = 0; beadIndex < beadCount; beadIndex++) {
            beadList[beadIndex] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        StringBuilder sb = new StringBuilder();
        for (int bead : beadList) {
            if (bead > 15000) {
                sb.append("N ");
            }
            else if (possible[bead]) {
                sb.append("Y ");
            }
            else {
                sb.append("N ");
            }
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int idx, int weight) {
        if (idx > weightCount || dp[idx][weight]) return;

        dp[idx][weight] = true;
        possible[weight] = true;

        if (idx == weightCount) return;

        dfs(idx + 1, weight); // 추 사용 안함
        dfs(idx + 1, weight + weightList[idx]); // 왼쪽에 놓음
        dfs(idx + 1, Math.abs(weight - weightList[idx])); // 오른쪽에 놓음
    }
}