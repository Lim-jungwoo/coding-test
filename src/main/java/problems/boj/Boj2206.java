package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2206 {
    public static class Node {
        int x;
        int y;
        int value;
        int canBreak; // 부실 수 있는 기회, 1: 부실 수 있음, 0: 부실 수 없음
        public Node(int x, int y, int value, int canBreak) {
            this.x = x;
            this.y = y;
            this.value = value;
            this.canBreak = canBreak;
        }
    }
    static int[][] map;
    static boolean[][][] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = (int) line.charAt(j) - '0';
            }
        }

        int result = bfs();
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = new int[] {-1,1,0,0};
    static int[] dy = new int[] {0,0,-1,1};

    static boolean isValid(int x, int y) {
        return 0 <= x && x < M && 0 <= y && y < N;
    }

    public static int bfs() {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 1));
        visited[0][0][1] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.y == N - 1 && curr.x == M - 1) return curr.value;

            for (int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if (!isValid(nx, ny)) continue;

                // 빈 공간이고, 방문하지 않은 경우
                if (map[ny][nx] == 0 && !visited[ny][nx][curr.canBreak]) {
                    visited[ny][nx][curr.canBreak] = true;
                    queue.add(new Node(nx, ny, curr.value + 1, curr.canBreak));
                }
                // 벽인데 부실 기회가 있고, 방문하지 않은 경우
                else if (map[ny][nx] == 1 && curr.canBreak == 1 && !visited[ny][nx][0]) {
                    visited[ny][nx][0] = true;
                    queue.add(new Node(nx, ny, curr.value + 1, 0));
                }
            }
        }
    return -1;
    }

}