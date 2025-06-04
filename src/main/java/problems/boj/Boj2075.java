package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            result = pq.poll();
        }

        bw.write(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}