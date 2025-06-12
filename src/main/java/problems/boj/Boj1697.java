package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1697 {
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = bfs(N, K);
        bw.write(Integer.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static boolean isValid(int x) {
        return 0 <= x && x <= 100000;
    }

    static int bfs(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N] = 0;

        while (true) {
            int pos = queue.poll();
            if (pos == K) break;

            // -1 위치
            int nPos = pos - 1;
            if (isValid(nPos) && visited[nPos] == 0) {
                queue.add(nPos);
                visited[nPos] = visited[pos] + 1;
            }
            // +1 위치
            nPos = pos + 1;
            if (isValid(nPos) && visited[nPos] == 0) {
                queue.add(nPos);
                visited[nPos] = visited[pos] + 1;
            }
            // x2 위치
            nPos = pos * 2;
            if (isValid(nPos) && visited[nPos] == 0) {
                queue.add(nPos);
                visited[nPos] = visited[pos] + 1;
            }

        }

        return visited[K];
    }
}