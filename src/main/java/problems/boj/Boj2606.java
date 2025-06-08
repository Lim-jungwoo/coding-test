package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[a].add(b);
            edges[b].add(a);
        }

        bfs(1);

        int answer = -1;
        for (int i = 1; i <= n; i++) {
            if (visited[i]) {
                answer++;
            }
        }

        bw.write(Integer.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            for (int dot : edges[queue.poll()]) {
                if (!visited[dot]) {
                    visited[dot] = true;
                    queue.add(dot);
                }
            }
        }
    }
}