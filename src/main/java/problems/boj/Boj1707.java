package problems.boj;

import java.util.*;
import java.io.*;

public class Boj1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            visited = new int[V + 1];
            HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<>();
            for (int j = 1; j <= V; j++) {
                edgeMap.put(j, new ArrayList<>());
            }
            int E = Integer.parseInt(st.nextToken());

            // 간선
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                edgeMap.get(start).add(end);
                edgeMap.get(end).add(start);
            }

            String result = solution(V, edgeMap);
            sb.append(result);
            if (i != K - 1) sb.append('\n');
        }

        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

    static int[] visited;

    static String solution(int V, HashMap<Integer, ArrayList<Integer>> edgeMap) {
        for (int i = 1; i <= V; i++) {
            if (visited[i] == 0)
                if (!bfs(i, edgeMap))
                    return "NO";
        }

        return "YES";
    }

    static boolean bfs(int start, HashMap<Integer, ArrayList<Integer>> edgeMap) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ArrayList<Integer> endList = edgeMap.get(curr);
            int groupNum = visited[curr];

            for (int end : endList) {
                if (visited[end] == groupNum) {
                    return false;
                }
                if (visited[end] != 0) {
                    continue;
                }
                visited[end] = -groupNum;
                queue.add(end);
            }
        }

        return true;
    }
}