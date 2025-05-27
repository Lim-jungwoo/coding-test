package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p2 {
    public static void main(String[] args) throws IOException {
//        int[] input = new int[]{4,2,2,1,3,4}; // [4,3,2,1]
        int[] input = new int[]{2,1,1,3,2,5,4}; // [5,4,3,2,1]

        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] input) {
        int[] clone = input.clone();
        Integer[] distinct = Arrays.stream(clone).distinct()
                .boxed().toArray(Integer[]::new);
        Arrays.sort(distinct, Comparator.reverseOrder());

        return Arrays.stream(distinct).mapToInt(Integer::intValue).toArray();
    }
}
