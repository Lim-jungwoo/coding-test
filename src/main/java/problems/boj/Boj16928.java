package problems.boj;

import java.io.*;
import java.util.*;

public class Boj16928 {
    static HashMap<Integer, Integer> ladders;
    static HashMap<Integer, Integer> snakes;
    static int[] visited = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ladders = new HashMap<>();
        snakes = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            ladders.put(start, end);
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            snakes.put(start, end);
        }

        int result = solution();
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x) {
        return 1 <= x && x <= 100;
    }

    static int solution() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        visited[1] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (isValid(next)) {
                    if (ladders.containsKey(next)) {
                        next = ladders.get(next);
                    } else if (snakes.containsKey(next)) {
                        next = snakes.get(next);
                    }

                    if (visited[next] == 0) {
                        visited[next] = visited[curr] + 1;
                        queue.add(next);
                    }
                }
            }

            if (visited[100] != 0) break;
        }

        return visited[100] - 1;
    }
}