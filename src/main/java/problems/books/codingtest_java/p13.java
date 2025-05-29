package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p13 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = new int[]{1,5,3,5,1,2,1,4}; // 4

        int result = solution(board, moves);
        System.out.println(Integer.toString(result));
    }

    static int solution(int[][] board, int[] moves) {
        ArrayDeque<Integer> bucket = new ArrayDeque<>();
        HashMap<Integer, ArrayDeque<Integer>> map = new HashMap<>();

        for (int i = 0; i < board[0].length; i++) {
            ArrayDeque<Integer> line = new ArrayDeque<Integer>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != 0) {
                    line.add(board[j][i]);
                }
            }
            map.put(i, line);
        }

        // 인형 뽑기
        int answer = 0;
        for (int move : moves) {
            ArrayDeque<Integer> line = map.getOrDefault(move - 1, new ArrayDeque<Integer>());
            // 인형 바구니에 넣기
            if (!line.isEmpty()) {
                int doll = line.pollFirst();
                // 인형 폭발
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                }
                // 인형 넣기
                else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }


}
