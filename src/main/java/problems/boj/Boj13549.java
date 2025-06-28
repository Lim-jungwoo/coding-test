package problems.boj;

import java.io.*;
import java.util.*;

public class Boj13549 {
    static int INF = Integer.MAX_VALUE;
    static int Max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Arrays.fill(visited, -1);

        bfs(N, K);

        int result = visited[K];

        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] visited = new int[100001];

    static boolean isValid(int x) {
        return 0 <= x && x <= Max;
    }

    static void bfs(int start, int end) {
        visited[start] = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == end) break;

            if (isValid(curr * 2) && visited[curr * 2] == -1) {
                visited[curr * 2] = visited[curr];
                queue.addFirst(curr * 2);
            }
            if (isValid(curr - 1) && visited[curr - 1] == -1) {
                visited[curr - 1] = visited[curr] + 1;
                queue.addLast(curr - 1);
            }
            if (isValid(curr + 1) && visited[curr + 1] == -1) {
                visited[curr + 1] = visited[curr] + 1;
                queue.addLast(curr + 1);
            }
        }
    }
}