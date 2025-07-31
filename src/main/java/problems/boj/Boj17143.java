package problems.boj;

import java.io.*;
import java.util.*;

public class Boj17143 {
    public static class Shark {
        int r, c, s, d, z;

        Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int[] dr = { 0, -1, 1, 0, 0};
    static int[] dc = { 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Shark>[][] map = new ArrayList[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if ((d == 1 || d == 2 )&& s >= 2 * (R - 1))
                s %= (2 * (R - 1));
            if ((d == 3 || d == 4) && s >= 2 * (C - 1))
                s %= (2 * (C - 1));
            int z = Integer.parseInt(st.nextToken());

            map[r][c].add(new Shark(r, c, s, d, z));
        }

        int score = 0;

        for (int king = 1; king <= C; king++) {
            // 상어 잡기
            for (int row = 1; row <= R; row++) {
                if (!map[row][king].isEmpty()) {
                    Shark caught = map[row][king].get(0);
                    score += caught.z;
                    map[row][king].clear();
                    break;
                }
            }

            // 상어 이동
            ArrayList<Shark>[][] newMap = new ArrayList[R + 1][C + 1];
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    newMap[i][j] = new ArrayList<>();
                }
            }

            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    for (Shark shark : map[i][j]) {
                        int r = shark.r;
                        int c = shark.c;
                        int s = shark.s;
                        int d = shark.d;
                        int z = shark.z;

                        for (int move = 0; move < s; move++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];

                            // 방향 반전
                            if (nr < 1 || nr > R || nc < 1 || nc > C) {
                                if (d == 1) d = 2;
                                else if (d == 2) d = 1;
                                else if (d == 3) d = 4;
                                else if (d == 4) d = 3;
                                nr = r + dr[d];
                                nc = c + dc[d];
                            }
                            r = nr;
                            c = nc;
                        }

                        Shark moved = new Shark(r, c, s, d, z);
                        newMap[r][c].add(moved);
                    }
                }
            }

            // 상어 잡아먹기
            for (int i = 1; i <= R; i++) {
                for (int j = 1; j <= C; j++) {
                    if (newMap[i][j].size() > 1) {
                        Shark biggest = newMap[i][j].get(0);
                        for (Shark shark : newMap[i][j]) {
                            if (shark.z > biggest.z) biggest = shark;
                        }
                        newMap[i][j].clear();
                        newMap[i][j].add(biggest);
                    }
                }
            }

            // 맵 갱신
            map = newMap;
        }

        bw.write(Integer.toString(score));

        br.close();
        bw.flush();
        bw.close();
    }


}