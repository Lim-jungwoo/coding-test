package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p6 {
    static double epsilon = 1e-9;
    static class Stage {
        public int success;
        public int fail;
        public int stageNum;
        public double failRate;
        public Stage(int success, int fail, int stageNum, double failRate) {
            this.success = success;
            this.fail = fail;
            this.stageNum = stageNum;
            this.failRate = failRate;
        }
    }
    public static void main(String[] args) throws IOException {
        int N = 5;
        int[] stages = new int[]{2,1,2,6,2,4,3,3}; // [3,4,2,1,5]
//        int N = 4;
//        int[] stages = new int[]{4,4,4,4,4}; // [4,1,2,3]

        int[] result = solution(N, stages);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int n, int[] stages) {
        Stage[] result = new Stage[n];
        for (int i = 0; i < n; i++) {
            result[i] = new Stage(0, 0, i + 1, 0);
        }

//        // 스테이지 내림차순 정렬
//        Integer[] clone = Arrays.stream(stages).boxed().sorted(Collections.reverseOrder()).toArray(Integer[]::new);
//
//        // 성공, 실패 확인
//        for (int i = 0; i < clone.length; i++) {
//            for (int j = 0; j < clone[i] - 1; j++) {
//                result[j].success += 1;
//            }
//            if (clone[i] != n + 1)
//                result[clone[i] - 1].fail += 1;
//        }

        int[] counter = new int[n + 2]; // 1~N+1 스테이지 개수 세기
        for (int stage : stages) {
            counter[stage]++;
        }

        int total = stages.length;
        for (int i = 1; i <= n; i++) {
            int fail = counter[i];
            int success = total - fail;
            result[i - 1].fail = fail;
            result[i - 1].success = success;
            result[i - 1].failRate = total == 0 ? 0.0 : (double) fail / total;
            total -= fail;
        }

        // 실패율 계산
        for (int i = 0; i < n; i++) {
            result[i].failRate = (double) result[i].fail / (result[i].success + result[i].fail);
        }

        // 실패율 내림차순 정렬
        Arrays.sort(result, (o1, o2) -> {
            if (o1.failRate - o2.failRate < epsilon)
                return Integer.compare(o1.stageNum, o2.stageNum);
            return Double.compare(o2.failRate, o1.failRate);
        });

        // 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(stage -> stage.stageNum).toArray();
    }
}
