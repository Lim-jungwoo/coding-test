package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11657 {
    public static class Edge {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edges.add(new Edge(from, to, cost));
        }

        StringBuilder sb = new StringBuilder();
        long[] result = bellmanFord(edges, N, 1);
        if (result == null) {
            sb.append(-1);
        }
        else {
            for (int i = 2; i < N + 1; i++) {
                if (result[i] == Integer.MAX_VALUE) {
                    sb.append(-1);
                }
                else {
                    sb.append(result[i]);
                }

                if (i != N)
                    sb.append('\n');
            }
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    public static long[] bellmanFord(ArrayList<Edge> edges, int vertex, int start) {
        long[] dist = new long[vertex + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 정점 개수 - 1 만큼 반복
        for (int i = 0; i < vertex - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        // 음수 사이클 확인
        for (Edge e : edges) {
            if (dist[e.from] != Integer.MAX_VALUE && dist[e.from] + e.cost < dist[e.to]) {
                return null;
            }
        }

        return dist;
    }
}