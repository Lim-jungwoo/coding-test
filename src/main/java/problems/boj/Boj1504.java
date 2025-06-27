package problems.boj;

import java.util.*;
import java.io.*;

public class Boj1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        graph = new ArrayList[N + 1];
        for (int n = 1; n <= N; n++) {
            graph[n] = new ArrayList<>();
        }

        int E = Integer.parseInt(st.nextToken());
        for (int e = 0; e < E; e++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph[v1].add(new int[]{v2,distance});
            graph[v2].add(new int[]{v1,distance});
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result = solution(v1, v2, N);
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] dist;
    // index -> 정점 번호, int[0] -> 정점 번호, int[1] -> 가중치
    static ArrayList<int[]>[] graph;

    static int solution(int v1, int v2, int N) {
        int dist1 = 0;
        // 1 -> v1 최단 경로
        dijkstra(1);
        if (dist[v1] == Integer.MAX_VALUE) return -1;
        dist1 += dist[v1];
        clearDist(N);

        // v1 -> v2 최단 경로
        dijkstra(v1);
        if (dist[v2] == Integer.MAX_VALUE) return -1;
        dist1 += dist[v2];
        clearDist(N);
        // v2 -> N 최단 경로
        dijkstra(v2);
        if (dist[N] == Integer.MAX_VALUE) return -1;
        dist1 += dist[N];
        clearDist(N);

        int dist2 = 0;
        // 1 -> v2 최단 경로
        dijkstra(1);
        if (dist[v2] == Integer.MAX_VALUE) return -1;
        dist2 += dist[v2];
        clearDist(N);
        // v2 -> v1 최단 경로
        dijkstra(v2);
        if (dist[v1] == Integer.MAX_VALUE) return -1;
        dist2 += dist[v1];
        clearDist(N);
        // v1 -> N 최단 경로
        dijkstra(v1);
        if (dist[N] == Integer.MAX_VALUE) return -1;
        dist2 += dist[N];
        clearDist(N);

        return Math.min(dist1, dist2);
    }

    static void clearDist(int N) {
        Arrays.fill(dist, Integer.MAX_VALUE);
    }

    static void dijkstra(int start) {
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((curr, next) -> Integer.compare(curr[1], next[1]));
        // [0] -> 정점 번호, [1] -> 가중치
        pq.add(new int[]{start,0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();

            if (dist[curr[0]] < curr[1]) continue;

            for (int[] vertexValue : graph[curr[0]]) {
                if (dist[vertexValue[0]] > vertexValue[1] + curr[1]) {
                    dist[vertexValue[0]] = vertexValue[1] + curr[1];
                    pq.add(new int[]{vertexValue[0], dist[vertexValue[0]]});
                }
            }
        }
    }
}