package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p20 {
    public static void main(String[] args) throws IOException {
        String[] wants = new String[] {
                "banana", "apple", "rice", "pork", "pot"
        };
        int[] numbers = new int[] {
                3, 2, 2, 2, 1
        };
        String[] discounts = new String[] {
                "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"
        }; // 3
//        String[] wants = new String[] {
//                "apple"
//        };
//        int[] numbers = new int[] {
//                10
//        };
//        String[] discounts = new String[] {
//                "banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana","banana"
//        }; // 0

        int result = solution(wants, numbers, discounts);
        System.out.println(Integer.toString(result));
    }

    static int solution(String[] wants, int[] numbers, String[] discounts) {
        HashMap<String, Integer> wantMap = new HashMap<>();
        // wantMap 초기화
        for (int i = 0; i < wants.length; i++) {
            wantMap.put(wants[i], numbers[i]);
        }

        int answer = 0;

        for (int i = 0; i <= discounts.length - 10; i++) {
            HashMap<String, Integer> discount10 = new HashMap<>();

            // 10일간 상품 목록
            for (int j = i; j < i + 10; j++) {
                discount10.merge(discounts[j], 1, Integer::sum);
            }

            // 원하는 상품과 할인 상품 비교
            if (discount10.equals(wantMap)) {
                answer++;
            }
        }

        return answer;
    }

}