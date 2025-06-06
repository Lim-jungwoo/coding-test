package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p19 {
    public static void main(String[] args) throws IOException {
//        String[] participants = new String[]{
//                "leo", "kiki", "eden"
//        };
//        String[] completions = new String[]{
//                "eden", "kiki"
//        }; // "leo"
        String[] participants = new String[]{
                "marina", "josipa", "nikola", "vinko", "filipa"
        };
        String[] completions = new String[]{
                "josipa", "filipa", "marina", "nikola"
        }; // "vinko"
//        String[] participants = new String[]{
//                "mislav", "stanko", "mislav", "ana"
//        };
//        String[] completions = new String[]{
//                "stanko", "ana", "mislav"
//        }; // "mislav"

        String result = solution(participants, completions);
        System.out.println(result);
    }

    static String solution(String[] participants, String[] completions) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String participant : participants) {
            if (map.containsKey(participant)) {
                map.compute(participant, (key, value) -> value + 1);
            }
            else {
                map.put(participant, 1);
            }
        }
        
        for (String completion : completions) {
            if (map.containsKey(completion)) {
                map.compute(completion, (key, value) -> value - 1);
                if (map.get(completion) == 0) {
                    map.remove(completion);
                }
            }
        }
        
        String result = "";
        for (String remain : map.keySet()) {
            result = remain;
        }
        return result;
    }
}