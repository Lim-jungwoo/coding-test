package problems.boj;

import java.util.*;
import java.io.*;

public class Boj6593 {
    static int[][][] building;
    static int L, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            // 입력 끝
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            // 맵 입력
            building = new int[L][R][C];
            int[] startPos = new int[3];
            int[] endPos = new int[3];
            for (int l = 0; l < L; l++) {
                for (int r = 0; r < R; r++) {
                    String row = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char value = row.charAt(c);
                        if (value == 'S') {
                            building[l][r][c] = 1;
                            startPos[0] = l;
                            startPos[1] = r;
                            startPos[2] = c;
                        }
                        if (value == 'E') {
                            building[l][r][c] = 1;
                            endPos[0] = l;
                            endPos[1] = r;
                            endPos[2] = c;
                        }
                        else if (value == '.')
                            building[l][r][c] = 1;
                        else
                            building[l][r][c] = -1;
                    }
                }
                br.readLine();
            }

            // 결과
            String result = bfs(startPos, endPos);
            sb.append(result);
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dx = {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,-1,1};

    static boolean isValid(int x, int y, int z) {
        return 0 <= z && z < L && 0 <= y && y < R && 0 <= x && x < C;
    }

    static String bfs(int[] startPos, int[] endPos) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(startPos);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[2];
            int y = cur[1];
            int z = cur[0];

            // 도착
            if (Arrays.equals(cur, endPos)) {
                return String.format("Escaped in %d minute(s).\n", building[z][y][x] + 1);
            }

            // 무빙!
            for (int i = 0; i < 6; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];
                int[] nPos = new int[]{nz,ny,nx};

                if (isValid(nx, ny, nz) && building[nz][ny][nx] == 1 && !Arrays.equals(nPos, startPos)) {
                    queue.add(nPos);
                    building[nz][ny][nx] += building[z][y][x];
                }
            }
        }

        return "Trapped!\n";
    }
}