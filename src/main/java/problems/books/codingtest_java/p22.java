package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p22 {
    public static void main(String[] args) throws IOException {
        String[] genres = new String[] {
                "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = new int[] {
                500, 600, 150, 800, 2500
        };
        int[] returns = new int[] {
                4,1,3,0
        };

        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (genreMap.containsKey(genres[i])) {
                genreMap.get(genres[i]).add(new int[] {i, plays[i]});
            }
            else {
                genreMap.put(genres[i], new ArrayList<>());
                genreMap.get(genres[i]).add(new int[] {i, plays[i]});
            }
        }

        // 장르별 총 플레이 횟수 내림차순 정렬
        TreeMap<Integer, String> genreTreeMap = new TreeMap<>(Comparator.reverseOrder());
        // 플레이 횟수 내림차순 정렬 -> 고유 번호 오름차순 정렬
        for (String genre : genreMap.keySet()) {
            ArrayList<int[]> sing = genreMap.get(genre);
            sing.sort((o1, o2) -> {
                if (o1[1] == o2[1])
                    return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o2[1], o1[1]);
            });

            // 장르별 총 플레이 횟수
            int totalPlay = 0;
            for (int i = 0; i < sing.size(); i++) {
                totalPlay += sing.get(i)[1];
            }
            genreTreeMap.put(totalPlay, genre);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (Integer totalPlay : genreTreeMap.keySet()) {
            String genre = genreTreeMap.get(totalPlay);
            ArrayList<int[]> singList = genreMap.get(genre);

            result.add(singList.get(0)[0]);
            if (singList.size() > 1) {
                result.add(singList.get(1)[0]);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}