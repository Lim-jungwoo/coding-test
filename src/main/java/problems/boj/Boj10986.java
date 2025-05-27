package problems.boj;

import java.util.*;
import java.io.*;

public class Boj10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        long[] prefix = new long[N + 1]; // 누적합을 M으로 나눈 나머지만 저장
        int[] count = new int[M]; // 누적합을 M으로 나눈 나머지의 개수
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefix[i] = (prefix[i - 1] + num);
            int remain = (int)(prefix[i] % M);
            count[remain]++;
        }

        // M으로 나누어 떨어지는 구간 구하기
        long result = count[0];
        for (int i = 0; i < M; i++) {
            if (count[i] >= 2) {
                result += (long) count[i] * (count[i] - 1) / 2;
            }
        }

        bw.write(Long.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}

