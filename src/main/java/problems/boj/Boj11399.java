package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 시간 오름차순 정렬
        Arrays.sort(P);

        int sum = 0, result = 0;
        for (int p : P) {
            sum += p;
            result += sum;
        }

        System.out.println(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}