package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2178 {
    static int[][] map;
    static int[][] visited;
    static int limitX;
    static int limitY;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        limitX = N;
        int M = Integer.parseInt(st.nextToken());
        limitY = M;

        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        bw.write(Integer.toString(visited[N - 1][M - 1]));

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x, int y) {
        return 0 <= x && x < limitX && 0 <= y && y < limitY;
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = 1;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if (isValid(nx, ny) && visited[nx][ny] == 0 && map[nx][ny] == 1) {
                    visited[nx][ny] = visited[curPos[0]][curPos[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }
}