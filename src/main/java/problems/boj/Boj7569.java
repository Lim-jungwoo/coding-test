package problems.boj;

import java.util.*;
import java.io.*;

public class Boj7569 {
    static int[][][] tomatoes;
    static int M;
    static int N;
    static int H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomatoes = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    tomatoes[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        int result = bfs();
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = new int[] {-1,1,0,0,0,0};
    static int[] dy = new int[] {0,0,-1,1,0,0};
    static int[] dz = new int[] {0,0,0,0,-1,1};

    static ArrayList<int[]> getStartPosList() {
        ArrayList<int[]> startPosList = new ArrayList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 1)
                        startPosList.add(new int[]{h,n,m});
                }
            }
        }
        return startPosList;
    }

    static boolean isValid(int x, int y, int z) {
        return 0 <= x && x < M && 0 <= y && y < N && 0 <= z && z < H;
    }

    static int getAnswer() {
        int answer = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (tomatoes[h][n][m] == 0) return -1;
                    answer = Math.max(answer, tomatoes[h][n][m]);
                }
            }
        }
        return answer - 1;
    }

    static int bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        ArrayList<int[]> startPosList = getStartPosList();
        for (int[] startPos : startPosList) {
            queue.add(startPos);
        }

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int x = curPos[2];
            int y = curPos[1];
            int z = curPos[0];

            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (isValid(nx, ny, nz) && tomatoes[nz][ny][nx] == 0) {
                    tomatoes[nz][ny][nx] = tomatoes[z][y][x] + 1;
                    queue.add(new int[]{nz, ny, nx});
                }
            }
        }

        return getAnswer();
    }
}