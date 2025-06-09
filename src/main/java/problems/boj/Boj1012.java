package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1012 {
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            map = new int[M][N];
            visited = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            int answer = 0;
            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (map[x][y] == 1 && !visited[x][y]) {
                        dfs(x, y, M, N);
                        answer++;
                    }
                }
            }
            sb.append(answer);
            if (i != T - 1) {
                sb.append('\n');
            }
        }

        bw.write(sb.toString());


        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x, int y, int limitX, int limitY) {
        return x >= 0 && x < limitX && y >= 0 && y < limitY;
    }

    static void dfs(int x, int y, int limitX, int limitY) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny, limitX, limitY) && map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny, limitX, limitY);
            }
        }
    }
}