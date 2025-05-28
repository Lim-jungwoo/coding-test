package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p9 {
    public static void main(String[] args) {
//        int decimal = 10;
//        int decimal = 27;
        int decimal = 12345;

        String result = solution(decimal);
        System.out.println(result);
    }

    static String solution(int decimal) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        while (true) {
            if (decimal == 1) {
                stack.push('1');
                break;
            }
            int remain = decimal % 2;
            stack.push((char)(remain + '0'));
            decimal /= 2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

}
