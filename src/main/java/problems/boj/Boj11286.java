package problems.boj;

import java.io.*;
import java.util.*;

public class Boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                }
                else {
                    int absNum = pq.poll();
                    sb.append(map.get(absNum).poll());
                }
                if (i != N - 1)
                    sb.append('\n');
            }
            else {
                pq.add(Math.abs(num));
                if (map.containsKey(Math.abs(num))) {
                    map.get(Math.abs(num)).add(num);
                }
                else {
                    PriorityQueue<Integer> arr = new PriorityQueue<>();
                    arr.add(num);
                    map.put(Math.abs(num), arr);
                }

            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}