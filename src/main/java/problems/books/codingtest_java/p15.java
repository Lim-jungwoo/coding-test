package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p15 {
    public static void main(String[] args) throws IOException {
        int N = 5, K = 2; // 3

        int result = solution(N, K);

        System.out.println(Integer.toString(result));
    }

    static int solution(int N, int K) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.addLast(i);
        }

        while (true) {
            for (int i = 0; i < K - 1; i++) {
                int num = queue.pollFirst();
                queue.addLast(num);
            }
            queue.pollFirst();
            if (queue.size() == 1) {
                break;
            }
        }

        return queue.pollFirst();
    }
}