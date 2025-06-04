package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] gems = new int[N][2];
        // 보석 정보
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            int[] gem = new int[] { weight, value };
            gems[i] = gem;
        }
        // 보석 무게 오름차순 정렬
        Arrays.sort(gems, (o1, o2) -> Integer.compare(o1[0], o2[0]));

        // 가방 무게 오름차순 정렬
        PriorityQueue<Integer> bagPq = new PriorityQueue<>();
        // 가방 정보
        for (int i = 0; i < K; i++) {
            bagPq.add(Integer.parseInt(br.readLine()));
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        long maxValue = 0;
        int gemIndex = 0;

        while (!bagPq.isEmpty()) {
            int bag = bagPq.poll();
            // 현재 가방에 둘어갈 수 있는 보석 모두 maxHeap에 추가
            while (gemIndex < N && gems[gemIndex][0] <= bag) {
                maxHeap.add(gems[gemIndex][1]); // 보석 가격만 넣음
                gemIndex++;
            }

            // 가장 비싼 보석 하나 꺼내서 가방에 넣음
            if (!maxHeap.isEmpty()) {
                maxValue += maxHeap.poll();
            }
        }


        bw.write(Long.toString(maxValue));

        bw.flush();
        bw.close();
        br.close();
    }
}