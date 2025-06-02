package problems.boj;

import java.util.*;
import java.io.*;

public class Boj1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lengths = new int[K];
        int max = 0;
        for (int i = 0; i < K; i++) {
            lengths[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lengths[i]);
        }

        long left = 1;
        long right = max;
        long result = 0;
        // 이분 탐색
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int length : lengths) {
                count += length / mid;
            }

            if (count >= N) {
                left = mid + 1;
                result = Math.max(result, mid);
            }
            else {
                right = mid - 1;
            }
        }

        bw.write(Long.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }
}
