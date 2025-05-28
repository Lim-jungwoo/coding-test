package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p8 {
    public static void main(String[] args) {
//        String s = "()()";
//        String s = "(())()";
//        String s = ")()(";
        String s = "(()(";

        boolean result = solution(s);
        System.out.println(result);
    }

    static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        char[] cArray = s.toCharArray();
        for (char c : cArray) {
            if (c == '(') {
                stack.push(c);
            }
            else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return true;
    }

}
