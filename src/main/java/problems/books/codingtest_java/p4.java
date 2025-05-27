package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p4 {
    public static void main(String[] args) throws IOException {
        int[] input = new int[]{1,2,3,4,5}; // [1]
//        int[] input = new int[]{1,3,2,4,2}; // [1,2,3]

        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] count = new int[3];

        for (int i = 0; i < input.length; i++) {
            // 첫 번째
            if ((i % 5 + 1) == input[i]) {
                count[0]++;
            }
            // 두 번째
            if ((i % 2 == 0 && input[i] == 2) ||
                    (i % 8 == 1 && input[i] == 1) ||
                    (i % 8 == 3 && input[i] == 3) ||
                    (i % 8 == 5 && input[i] == 4) ||
                    (i % 8 == 7 && input[i] == 5)) {
                count[1]++;
            }
            // 세 번째
            if (((i % 10 == 0 || i % 10 == 1) && input[i] == 3) ||
                    ((i % 10 == 2 || i % 10 == 3) && input[i] == 1) ||
                    ((i % 10 == 4 || i % 10 == 5) && input[i] == 2) ||
                    ((i % 10 == 6 || i % 10 == 7) && input[i] == 4) ||
                    ((i % 10 == 8 || i % 10 == 9) && input[i] == 5)) {
                count[2]++;
            }
        }

        int maxCount = Arrays.stream(count).max().getAsInt();
        for (int i = 0; i < 3; i++) {
            if (count[i] == maxCount) {
                result.add(i + 1);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
