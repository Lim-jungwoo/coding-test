package problems.boj;

import java.util.*;
import java.io.*;

public class Boj6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            // 마지막 입력
            if (N == 0) break;

            long[] heights = new long[N + 1];
            // 마지막 값을 비교하기 위해 0을 넣는다.
            heights[N] = 0;
            for (int i = 0; i < N; i++) {
                heights[i] = Long.parseLong(st.nextToken());
            }

            ArrayDeque<Integer> stack = new ArrayDeque<>();
            // 높이가 작아지기 전까지 인덱스를 계속 저장
            // heights[stack.peek()] > heights[i]면 계속 pop
            long maxArea = 0;
            for (int i = 0; i <= N; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    long height = heights[stack.pop()];
                    long width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, height * width);
                }
                stack.push(i);
            }

            bw.write(Long.toString(maxArea) + '\n');
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
