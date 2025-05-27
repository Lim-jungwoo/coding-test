package problems.boj;

import java.util.*;
import java.io.*;

public class Boj2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] temp = new int[N + 1];
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + temp[i];
        }

        int[] result = new int[N + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= N - K; i++) {
            result[i] = prefix[K + i] - prefix[i];
            max = Math.max(max, result[i]);
        }
        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
        br.close();
    }
}

