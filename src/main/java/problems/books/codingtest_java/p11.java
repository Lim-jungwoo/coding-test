package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p11 {
    public static void main(String[] args) {
//        String s = "baabaa"; // 1
        String s = "cdcd"; // 0

        int result = solution(s);
        System.out.println(Integer.toString(result));
    }

    static int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
