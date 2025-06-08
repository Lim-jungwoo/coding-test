package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1260 {
    static int[] dfsVisited;
    static int dfsOrder = 1;
    static ArrayList<Integer>[] dfsEdges;
    static int[] bfsVisited;
    static int bfsOrder = 1;
    static ArrayList<Integer>[] bfsEdges;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        dfsVisited = new int[N + 1];
        dfsEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            dfsEdges[i] = new ArrayList<>();
        }
        bfsVisited = new int[N + 1];
        bfsEdges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            bfsEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dfsEdges[a].add(b);
            dfsEdges[b].add(a);
            bfsEdges[a].add(b);
            bfsEdges[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            dfsEdges[i].sort(Comparator.naturalOrder());
            bfsEdges[i].sort(Comparator.naturalOrder());
        }

        dfs1(V);
//        dfs2(V);
        sb.append('\n');
        bfs(V);

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs1(int start) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            if (dfsVisited[curr] != 0) continue;
            dfsVisited[curr] = dfsOrder++;
            sb.append(curr);
            sb.append(' ');

            for (int i = dfsEdges[curr].size() - 1; i >= 0; i--) {
                int dot = dfsEdges[curr].get(i);
                stack.push(dot);
            }
        }
    }

    static void dfs2(int start) {
        if (dfsVisited[start] != 0) return;
        dfsVisited[start] = dfsOrder++;
        sb.append(start);
        sb.append(' ');

        for (int edge : dfsEdges[start]) {
            dfs2(edge);
        }
    }

    static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        bfsVisited[start] = bfsOrder++;
        sb.append(start);
        sb.append(' ');
        queue.add(start);

        while (!queue.isEmpty()) {
            for (int edge : bfsEdges[queue.poll()]) {
                if (bfsVisited[edge] != 0) continue;
                bfsVisited[edge] = bfsOrder++;
                sb.append(edge);
                sb.append(' ');
                queue.add(edge);
            }
        }
    }
}