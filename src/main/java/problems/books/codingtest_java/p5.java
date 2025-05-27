package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p5 {
    public static void main(String[] args) throws IOException {
//        int[][] arr1 = new int[][]{
//                {1,4}, {3,2}, {4,1}
//        };
//        int[][] arr2 = new int[][]{
//                {3,3}, {3,3}
//        }; // [[15,15],[15,15],[15,15]]
        int[][] arr1 = new int[][]{
                {2,3,2}, {4,2,4}, {3,1,4}
        };
        int[][] arr2 = new int[][]{
                {5,4,3}, {2,4,1}, {3,1,1}
        }; // [[22,22,11],[36,28,18],[29,20,14]]


        int[][] result = solution(arr1, arr2);
        for (int i = 0; i < result.length; i++)
            System.out.println(Arrays.toString(result[i]));
    }

    static int[][] solution(int[][] arr1, int[][] arr2) {
        int a = arr1.length;
        int b = arr1[0].length;
        int c = arr2[0].length;

        int[][] result = new int[a][c];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < b; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }
}
