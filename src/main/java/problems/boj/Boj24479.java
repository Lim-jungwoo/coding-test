package problems.boj;

import java.io.*;
import java.util.*;

public class Boj24479 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(a, k -> new TreeSet<>()).add(b);
            map.computeIfAbsent(b, k -> new TreeSet<>()).add(a);
        }

        visited = new int[N + 1];
        dfs(map, R);
        for (int i = 1; i <= N; i++) {
            if (visited[i] != 0) {
                sb.append(visited[i]);
                sb.append('\n');
            }
            else {
                sb.append(0);
                sb.append('\n');
            }
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static int[] visited;
    static int index = 1;
    static StringBuilder sb = new StringBuilder();

    static void dfs(HashMap<Integer, TreeSet<Integer>> map, int R) {
        visited[R] = index++;

        TreeSet<Integer> set = map.getOrDefault(R, new TreeSet<>());
        // 연결된 점이 없을 경우
        if (set.isEmpty()) {
            return ;
        }
        // 연결된 점이 있을 경우
        else {
            for (int num : set) {
                if (visited[num] == 0)
                    dfs(map, num);
            }
        }

    }
}