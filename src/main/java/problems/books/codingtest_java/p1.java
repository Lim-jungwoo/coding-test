package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p1 {
    public static void main(String[] args) throws IOException {
        int[] input = new int[]{1,-5,2,4,3}; // [-5,1,2,3,4]
//        int[] input = new int[]{2,1,1,3,2,5,4}; // [1,1,2,2,3,4,5]
//        int[] input = new int[]{6,1,7}; // [1,6,7]

        int[] result = solution(input);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] input) {
        Arrays.sort(input);
        return input;
    }
}
