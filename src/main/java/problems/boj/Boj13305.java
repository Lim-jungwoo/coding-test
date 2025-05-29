package problems.boj;

import java.io.*;
import java.util.*;

public class Boj13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] roads = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] cities = new int[N];
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        long min = cities[0];
        long result = (long) cities[0] * roads[0];
        for (int i = 1; i < N - 1; i++) {
            min = Math.min(min, cities[i]);
            result += min * roads[i];
        }

        System.out.println(Long.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}