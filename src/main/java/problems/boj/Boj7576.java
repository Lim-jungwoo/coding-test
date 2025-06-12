package problems.boj;

import java.io.*;
import java.util.*;

public class Boj7576 {
    static int[][] tomatoes;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        tomatoes = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = tomatoes[i][j];
            }
        }

        int result = solution(N, M);
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};

    static boolean isValid(int x, int y, int limitX, int limitY) {
        return 0 <= x && x < limitX && 0 <= y && y < limitY && tomatoes[x][y] == 0;
    }

    static int checkAnswer(int limitX, int limitY) {
        int max = 0;
        for (int i = 0; i < limitX; i++) {
            for (int j = 0; j < limitY; j++) {
                if (visited[i][j] == 0)
                    return -1;
                max = Math.max(max, visited[i][j]);
            }
        }
        return max - 1;
    }

    static int solution(int limitX, int limitY) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < limitX; i++) {
            for (int j = 0; j < limitY; j++) {
                if (tomatoes[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int x = curPos[0];
            int y = curPos[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, limitX, limitY) && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return checkAnswer(limitX, limitY);
    }
}