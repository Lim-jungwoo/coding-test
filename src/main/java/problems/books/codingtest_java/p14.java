package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p14 {
    public static void main(String[] args) throws IOException {
//        int n = 8, k = 2;
//        String[] cmds = new String[] {
//                "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"
//        }; // "OOOOXOOO"
        int n = 8, k = 2;
        String[] cmds = new String[] {
                "D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"
        }; // "OOXOXOOO"

        String result = solution(n, k, cmds);
        System.out.println(result);
    }

    static String solution(int n, int k, String[] cmds) {

        // 삭제한 인덱스 저장
        ArrayDeque<Integer> restoreStack = new ArrayDeque<>();

        // 가상공간 위아래 하나씩 추가
        // up 인덱스
        int[] up = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            up[i] = i - 1;
        }
        // down 인덱스
        int[] down = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            down[i] = i + 1;
        }

        // 양 끝에 가상공간을 추가했기 때문에, 시작 위치 + 1
        k++;

        for (String cmd : cmds) {
            char c = cmd.charAt(0);

            if (c == 'D' || c == 'U') {
                int num = cmd.charAt(2) - '0';
                for (int i = 0; i < num; i++) {
                    k = c == 'U' ? up[k] : down[k];
                }
            }
            else if (c == 'C') {
                restoreStack.push(k);
                down[up[k]] = down[k];
                up[down[k]] = up[k];
                k = n < down[k] ? up[k] : down[k];
            }
            else if (c == 'Z'){
                int restore = restoreStack.pop();
                up[down[restore]] = restore;
                down[up[restore]] = restore;
            }
        }

        char[] answer = new char[n];
        Arrays.fill(answer, 'O');

        for (int restore : restoreStack) {
            answer[restore - 1] = 'X';
        }

        return new String(answer);
    }
}