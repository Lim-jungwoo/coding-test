package problems.books.codingtest_java;

import java.util.*;
import java.io.*;

public class p7 {
    public static void main(String[] args) throws IOException {
//        String dirs = "ULURRDLLU"; // 7
        String dirs = "LULLLLLLU"; // 7

        int result = solution(dirs);
        System.out.println(result);
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }

    static int solution(String dirs) {
        int[][][] coordinate = new int[10][10][4];
        int[] curr = new int[]{5,5};
        int answer = 0;

        for (int i = 0; i < dirs.length(); i++) {
            switch (dirs.charAt(i)) {
                case 'U':
                    if (isValid(curr[0], curr[1] + 1)) {
                        if (!(coordinate[curr[1]][curr[0]][3] == 1 || coordinate[curr[1]+1][curr[0]][2] == 1)) {
                            coordinate[curr[1]][curr[0]][3] = 1;
                            coordinate[curr[1] + 1][curr[0]][2] = 1;
                            answer++;
                        }
                        curr[1] = curr[1] + 1;
                    }
                    break;
                case 'D':
                    if (isValid(curr[0], curr[1] - 1)) {
                        if (!(coordinate[curr[1]][curr[0]][2] == 1 || coordinate[curr[1]-1][curr[0]][3] == 1)) {
                            coordinate[curr[1]][curr[0]][2] = 1;
                            coordinate[curr[1] - 1][curr[0]][3] = 1;
                            answer++;
                        }
                        curr[1] = curr[1] - 1;
                    }
                    break;
                case 'L':
                    if (isValid(curr[0] - 1, curr[1])) {
                        if (!(coordinate[curr[1]][curr[0]][0] == 1 || coordinate[curr[1]][curr[0]-1][1] == 1)) {
                            coordinate[curr[1]][curr[0]][0] = 1;
                            coordinate[curr[1]][curr[0] - 1][1] = 1;
                            answer++;
                        }
                        curr[0] = curr[0] - 1;
                    }
                    break;
                case 'R':
                    if (isValid(curr[0] + 1, curr[1])) {
                        if (!(coordinate[curr[1]][curr[0]][1] == 1 || coordinate[curr[1]][curr[0]+1][0] == 1)) {
                            coordinate[curr[1]][curr[0]][1] = 1;
                            coordinate[curr[1]][curr[0] + 1][0] = 1;
                            answer++;
                        }
                        curr[0] = curr[0] + 1;
                    }
                    break;
            }
        }

        return answer;
    }

    // solution 2
    static final HashMap<Character, int[]> location = new HashMap<>();

    static void initLocation() {
        location.put('U', new int[]{0,1});
        location.put('D', new int[]{0,-1});
        location.put('L', new int[]{-1,0});
        location.put('R', new int[]{1,0});
    }

    static boolean isValidMove(int x, int y) {
        return x >= 0 && x < 11 && y >= 0 && y < 11;
    }

    static int solution2(String dirs) {
        initLocation();
        HashSet<String> answer = new HashSet<>();
        int x = 5, y = 5;

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isValidMove(x, y)) continue;

            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            x = nx;
            y = ny;
        }

        return answer.size() / 2;
    }
}
