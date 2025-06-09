package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2667 {
    static int N;
    static int[][] map;
    static int[][] visited;
    static int num = 1;
    static int count = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = (int) line.charAt(j) - '0';
            }
        }

        ArrayList<Integer> house = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0 && map[i][j] == 1) {
                    dfs(i, j);
                    house.add(count);
                    num++;
                    count = 0;
                }
            }
        }

        house.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(num - 1).append('\n');
        for (int i = 0; i < house.size(); i++) {
            sb.append(house.get(i));
            if (i != house.size() - 1)
                sb.append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static boolean isHouse(int x, int y) {
        return map[x][y] == 1;
    }

    static void dfs(int x, int y) {
        if (visited[x][y] != 0 || !isHouse(x, y)) return;
        visited[x][y] = num;
        count++;

        // 위,아래,왼쪽,오른쪽 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isValid(nx, ny) && isHouse(nx, ny) && visited[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }
}