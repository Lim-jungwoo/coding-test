package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p23 {
    public static void main(String[] args) throws IOException {
        String[] id_list = new String[] {
                "muzi", "frodo", "apeach", "neo"
        };
        String[] reports = new String[] {
                "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"
        };
        int k = 2;
        int[] result = new int[] {2,1,1,0};
//        String[] id_list = new String[] {
//                "con", "ryan"
//        };
//        String[] reports = new String[] {
//                "ryan con","ryan con","ryan con","ryan con"
//        };
//        int k = 3;
//        int[] result = new int[] {0,0};

        int[] answer = solution(id_list, reports, k);
        System.out.println(Arrays.toString(answer));
    }

    static int[] solution(String[] id_list, String[] reports, int k) {
        HashMap<String, HashSet<String>> reportMap = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (int i = 0; i < reports.length; i++) {
            String[] report = reports[i].split(" ");
            reportMap.get(report[1]).add(report[0]);
        }

        HashMap<String, Integer> answerMap = new HashMap<>();
        for (String id : reportMap.keySet()) {
            HashSet<String> set = reportMap.get(id);
            if (set.size() >= k) {
                for (String reporter : set) {
                    answerMap.merge(reporter, 1, (prev, next) -> prev + 1);
                }
            }
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = answerMap.getOrDefault(id_list[i], 0);
        }

        return answer;
    }
}