package problems.boj;

import java.util.*;
import java.io.*;

public class Boj2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] homes = new int[N];
        long maxDistance = 0;
        for (int i = 0; i < N; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }

        // 좌표 오름차순 정렬
        Arrays.sort(homes);
        // 집 간 최대 거리
        maxDistance = homes[N - 1] - homes[0];

        long left = 1;
        long right = maxDistance;
        long answer = 0;

        // 집 간 최대 거리 증가할수록, 공유기 개수 증가
        while (left <= right) {
            long mid = (left + right) / 2;

            // 첫 번째 집에는 무조건 설치
            long count = 1;
            int last = homes[0];
            for (int i = 1; i < homes.length; i++) {
                if (homes[i] - last >= mid) {
                    count++;
                    last = homes[i];
                }
            }

            // 조건 만족, 정답 후보
            // 더 큰 거리 탐색
            if (count >= C) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            // 조건 불만족, 더 작은 거리 탐색
            else {
                right = mid - 1;
            }
        }

        bw.write(Long.toString(answer));

        br.close();
        bw.flush();
        bw.close();
    }
}