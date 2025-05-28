package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p10 {
    public static void main(String[] args) {
        String s = "[](){}"; // 3
//        String s = "}]()[{"; // 2
//        String s = "[)(]"; // 0
//        String s = "}}}"; // 0

        int result = solution(s);
        System.out.println(result);
    }

    static int solution(String s) {
        ArrayDeque<Character> checkStack = new ArrayDeque<>();
        String doubleS = s + s;
        int len = s.length();
        int answer = 0;

        A: for (int i = 0; i < len; i++) {
            checkStack.clear();
            for (int j = i; j < len + i; j++) {
                char checkChar = doubleS.charAt(j);
                if (checkChar == '[' || checkChar == '{' || checkChar == '(') {
                    checkStack.push(checkChar);
                }
                else {
                    if (checkStack.isEmpty()) {
                        continue A;
                    }
                    char popChar = checkStack.pop();
                    if (popChar == '[' && !(checkChar == ']') ||
                            popChar == '{' && !(checkChar == '}') ||
                            popChar == '(' && !(checkChar == ')')) {
                        continue A;
                    }
                }

            }
            if (checkStack.isEmpty())
                answer++;
        }

        return answer;
    }
}
