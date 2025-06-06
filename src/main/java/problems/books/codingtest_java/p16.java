package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p16 {
    public static void main(String[] args) throws IOException {
//        int[] progresses = { 93,30,55 };
//        int[] speeds = { 1,30,5 }; // [2, 1]
        int[] progresses = { 95,90,99,99,80,99 };
        int[] speeds = { 1,1,1,1,1,1 }; // [1, 3, 2]

        int[] result = solution(progresses, speeds);

        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayDeque<Integer> progressQueue = new ArrayDeque<>();
        ArrayDeque<Integer> speedQueue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            progressQueue.addLast(progresses[i]);
            speedQueue.addLast(speeds[i]);
        }

        while (!progressQueue.isEmpty()) {
            for (int i = 0; i < progressQueue.size(); i++) {
                int progress = progressQueue.pollFirst();
                int speed = speedQueue.pollFirst();
                progressQueue.addLast(progress + speed);
                speedQueue.addLast(speed);
            }

            int count = 0;
            while (!progressQueue.isEmpty() && progressQueue.peek() >= 100) {
                progressQueue.pollFirst();
                speedQueue.pollFirst();
                count++;
            }
            if (count > 0) {
                answer.add(count);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}