package problems.boj;

import java.io.*;
import java.util.*;

public class Boj7562 {
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int I = Integer.parseInt(br.readLine());
            int[] night = new int[2];
            int[] target = new int[2];
            st = new StringTokenizer(br.readLine());
            night[0] = Integer.parseInt(st.nextToken());
            night[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            target[0] = Integer.parseInt(st.nextToken());
            target[1] = Integer.parseInt(st.nextToken());

            visited = new int[I][I];
            int result = bfs(night, target, I);
            sb.append(result);
            if (i != T - 1) sb.append('\n');
        }
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};

    static boolean isValid(int x, int y, int I) {
        return 0 <= x && x < I && 0 <= y && y < I;
    }

    static int bfs(int[] night, int[] target, int I) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[night[0]][night[1]] = 0;
        queue.add(new int[]{night[0], night[1]});

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            if (curPos[0] == target[0] && curPos[1] == target[1]) {
                break;
            }
            int x = curPos[0];
            int y = curPos[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValid(nx, ny, I) && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return visited[target[0]][target[1]];
    }
}