package problems.boj;

import java.util.*;
import java.io.*;

public class Boj11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] lisDp = new int[n];
        Arrays.fill(lisDp, 1);
        int[] ldsDp = new int[n];
        Arrays.fill(ldsDp, 1);;

        // 증가 수열
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    lisDp[j] = Math.max(lisDp[j], lisDp[i] + 1);
                }
            }
        }
        // 감소 수열
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    ldsDp[j] = Math.max(ldsDp[j], ldsDp[i] + 1);
                }
            }
        }

        // 최대 길이, 증가 끝 & 감소 시작 인덱스 구하기
        int maxLength = 1;
        int peakIndex = 0;
        for (int i = 0; i < n; i++) {
            int total = lisDp[i] + ldsDp[i] - 1;
            if (total > maxLength) {
                maxLength = total;
                peakIndex = i;
            }
        }

        // 수열 복원
        List<Integer> result = new ArrayList<>();

        // 증가 수열 복원
        int lisValue = lisDp[peakIndex];
        for (int i = peakIndex; i >= 0; i--) {
            if (lisDp[i] == lisValue) {
                result.add(0, nums[i]);
                lisValue--;
            }
        }

        // 감소 수열 복원
        int ldsValue = ldsDp[peakIndex] - 1;
        for (int i = peakIndex + 1; i < n; i++) {
            if (ldsDp[i] == ldsValue) {
                result.add(nums[i]);
                ldsValue--;
            }
        }

        bw.write(Integer.toString(maxLength) + '\n');
        bw.write(Arrays.toString(result.stream().mapToInt(Integer::intValue).toArray()));

        bw.flush();
        bw.close();
        br.close();
    }
}
