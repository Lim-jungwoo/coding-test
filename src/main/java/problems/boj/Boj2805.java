package problems.boj;

import java.util.*;
import java.io.*;

public class Boj2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        long max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        long left = 1;
        long right = max;
        long answer = 0;
        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int tree : trees) {
                if (tree - mid > 0)
                    count += (tree - mid);
            }

            if (count >= M) {
                left = mid + 1;
                answer = Math.max(answer, mid);
            }
            else {
                right = mid - 1;
            }
        }

        bw.write(Long.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}
