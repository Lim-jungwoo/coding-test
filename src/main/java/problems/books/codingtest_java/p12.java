package problems.books.codingtest_java;

import java.util.*;

public class p12 {
    public static void main(String[] args) {
//        int[] prices = new int[]{1,2,3,2,3}; // [4,3,1,1,0]
//        int[] prices = new int[]{1}; // [0]
//        int[] prices = new int[]{1,2}; // [1,0]
        int[] prices = new int[]{3,2,1}; // [1,1,0]

        int[] result = solution(prices);
        System.out.println(Arrays.toString(result));
    }

    // solution => O(N)
    static int[] solution(int[] prices) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] answer = new int[prices.length];
        int days = 0;

        for (int i = 0; i < prices.length; i++) {
            // 첫 주식 넣기
            if (i == 0) {
                stack.push(new int[]{i,prices[i]});
                continue;
            }

            days++;

            // 현재 주식 가격초과인 주식은 모두 pop
            while (!stack.isEmpty() && stack.peek()[1] > prices[i]) {
                int[] orderPrice = stack.pop();
                answer[orderPrice[0]] = days - orderPrice[0];
            }

            stack.push(new int[]{i,prices[i]});
        }

        // stack 비우기
        while (!stack.isEmpty()) {
            int[] orderPrice = stack.pop();
            answer[orderPrice[0]] = days - orderPrice[0];
        }

        return answer;
    }


}
