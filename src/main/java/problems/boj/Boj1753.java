package problems.boj;

import java.util.*;
import java.io.*;

public class Boj1753 {
    static ArrayList<int[]>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V + 1];
        visited = new int[V + 1];

        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        for (int v = 1; v <= V; v++) {
            graph[v] = new ArrayList<>();
            visited[v] = Integer.MAX_VALUE;
        }
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to,value});
        }

        solution(K);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (visited[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            } else {
                sb.append(visited[i]).append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void solution(int start) {
        visited[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((curr, next) -> Integer.compare(curr[1], next[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int from = curr[0];
            int value = curr[1];

            if (visited[from] < value) continue;

            for (int[] toValue : graph[from]) {
                if (visited[toValue[0]] > value + toValue[1]) {
                    visited[toValue[0]] = value + toValue[1];
                    pq.add(new int[]{toValue[0], visited[toValue[0]]});
                }
            }
        }
    }
}