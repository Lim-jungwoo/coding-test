package problems.boj;

import java.util.*;
import java.io.*;

public class Boj2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[N + 1];
        for (int n = 0; n <= N; n++) {
            graph.add(new ArrayList<>());
        }

        // 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            graph.get(first).add(second);
            indegree[second]++;
        }

        // 로직
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int n = 1; n <= N; n++) {
            if (indegree[n] == 0) {
                queue.add(n);
            }
        }

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            sb.append(curr).append(' ');

            ArrayList<Integer> nextList = graph.get(curr);
            for (int next : nextList) {
                indegree[next]--;
                if (indegree[next] == 0) queue.add(next);
            }
        }

        // 출력
        bw.write(sb.toString());

        br.close();
        bw.flush();
        bw.close();
    }

}