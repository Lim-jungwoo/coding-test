package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11062 {
    static int[] card;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            card = new int[N];
            dp = new int[N][N];
            visited = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                card[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(dfs(0,N-1,true)).append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int dfs(int l, int r, boolean isG) {
        if (l > r) return 0;
        if (visited[l][r]) return dp[l][r];

        int result = 0;
        if (isG) {
            result = Math.max(
                    card[l] + dfs(l+1,r,false),
                    card[r] + dfs(l,r-1,false)
            );
        }
        else {
            result = Math.min(
                    dfs(l+1,r,true),
                    dfs(l,r-1,true)
            );
        }

        visited[l][r] = true;
        dp[l][r] = result;
        return result;
    }
}