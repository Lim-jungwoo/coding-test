package problems.boj;

import java.util.*;
import java.io.*;

public class Boj11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] num = new int[N + 1];
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            prefix[i] += num[i] + prefix[i - 1];
        }

        int[][] interval = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            interval[i][0] = Integer.parseInt(st.nextToken());
            interval[i][1] = Integer.parseInt(st.nextToken());
        }

        // 구간 합 출력
        for (int i = 0; i < M; i++) {
            int start = interval[i][0];
            int end = interval[i][1];
            int result = 0;
            result = prefix[end] - prefix[start - 1];
            bw.write(Integer.toString(result));
            if (i != M - 1)
                bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

