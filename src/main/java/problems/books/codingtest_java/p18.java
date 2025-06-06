package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p18 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[] {1,2,3,4,8};
        int target = 6; // true;
//        int[] arr = new int[] {2,3,5,9};
//        int target = 10; // false;

        boolean result = solution(arr, target);
        System.out.println(result);
    }

    static boolean solution(int[] arr, int target) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int find = target;
            if (!set.isEmpty()) {
                find -= arr[i];
                if (set.contains(find)) {
                    return true;
                }
            }
            set.add(arr[i]);
        }

        return false;
    }
}