package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1520 {
    static int[][] map;
    static int[][] dp;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        int result = dfs(0, 0);
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    static boolean isValid(int x, int y, int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M && map[y][x] > map[ny][nx];
    }

    static int dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) return 1;

        if (dp[y][x] != -1) return dp[y][x];

        dp[y][x] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(x, y, nx, ny)) {
                dp[y][x] += dfs(nx, ny);
            }
        }

        return dp[y][x];
    }

}