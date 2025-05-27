package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p3 {
    public static void main(String[] args) throws IOException {
        int[] input = new int[]{2,1,3,4,1}; // [2,3,4,5,6,7]
//        int[] input = new int[]{5,0,2,7}; // [2,5,7,9,12]

        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] input) {
        int[] clone = input.clone();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < clone.length; i++) {
            for (int j = i + 1; j < clone.length; j++) {
                set.add(clone[i] + clone[j]);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
