package problems.boj;

import java.io.*;
import java.util.*;

public class Boj24480 {
    static int[] visited;
    static ArrayList<Integer>[] arr;
    static int order = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];
        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }

        // 내림차 순 정렬
        for (int i = 1; i <= N; i++) {
            arr[i].sort(Comparator.reverseOrder());
        }

        dfs(R);
        for (int i = 1; i <= N; i++) {
            bw.write(Integer.toString(visited[i]));
            if (i != N)
                bw.write('\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }

    static void dfs(int R) {
        visited[R] = order++;

        for (int dot : arr[R]) {
            if (visited[dot] == 0) {
                dfs(dot);
            }
        }
    }
}