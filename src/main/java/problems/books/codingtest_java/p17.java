package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p17 {
    public static void main(String[] args) throws IOException {
        String[] cards1 = new String[]{
                "i", "drink", "water"
        };
        String[] cards2 = new String[]{
                "want", "to"
        };
        String[] goal = new String[]{
                "i", "want", "to", "drink", "water"
        }; // "Yes"
//        String[] cards1 = new String[]{
//                "i", "water", "drink"
//        };
//        String[] cards2 = new String[]{
//                "want", "to"
//        };
//        String[] goal = new String[]{
//                "i", "want", "to", "drink", "water"
//        }; // "No"

        String result = solution(cards1, cards2, goal);

        System.out.println(result);
    }

    static String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cards1Queue = new ArrayDeque<>();
        ArrayDeque<String> cards2Queue = new ArrayDeque<>();

        for (int i = 0; i < cards1.length; i++) {
            cards1Queue.addLast(cards1[i]);
        }
        for (int i = 0; i < cards2.length; i++) {
            cards2Queue.addLast(cards2[i]);
        }

        for (int i = 0; i < goal.length; i++) {
            if (!cards1Queue.isEmpty() && Objects.equals(cards1Queue.peek(), goal[i])) {
                cards1Queue.pollFirst();
            }
            else if (!cards2Queue.isEmpty() && Objects.equals(cards2Queue.peek(), goal[i])) {
                cards2Queue.pollFirst();
            }
            else {
                return "No";
            }
        }

        return "Yes";
    }
}