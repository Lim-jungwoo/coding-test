package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());
            int[] nums = new int[M];

            for (int j = 0; j <= M / 10; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = j * 10; k < Math.min((j + 1) * 10, M); k++) {
                    nums[k] = Integer.parseInt(st.nextToken());
                }
            }

            // 중앙값보다 큰 수
            PriorityQueue<Integer> right = new PriorityQueue<>();
            // 중앙값보다 작은 수
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
            // 중앙값, 수열의 첫 번째 수로 초기화
            int median = nums[0];
            // 출력할 중앙값 저장
            int[] medianList = new int[(M + 1) / 2];
            medianList[0] = median;

            for (int order = 1; order < M; order += 2) {
                if (median > nums[order]) {
                    left.add(nums[order]);
                }
                else {
                    right.add(nums[order]);
                }
                if (median > nums[order + 1]) {
                    left.add(nums[order + 1]);
                }
                else {
                    right.add(nums[order + 1]);
                }

                if (right.size() > left.size()) {
                    left.add(median);
                    median = right.poll();
                }
                else if (right.size() < left.size()) {
                    right.add(median);
                    median = left.poll();
                }
                medianList[(order + 1) / 2] = median;
            }

            bw.write(Integer.toString(medianList.length) + '\n');
            for (int len = 0; len < medianList.length; len++) {
                bw.write(Integer.toString(medianList[len]));
                if (len != medianList.length - 1)
                    bw.write(" ");
                if ((len + 1) % 10 == 0)
                    bw.write('\n');
            }
            if (i != T - 1)
                bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}