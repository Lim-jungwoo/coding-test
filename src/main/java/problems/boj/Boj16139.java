package problems.boj;

import java.util.*;
import java.io.*;

public class Boj16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int q = Integer.parseInt(br.readLine());
        int[][] question = new int[q][3];
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            question[i][0] = st.nextToken().charAt(0) - 'a';
            question[i][1] = Integer.parseInt(st.nextToken());
            question[i][2] = Integer.parseInt(st.nextToken());
        }

        // i번째 문자까지 알파벳의 누적합
        int[][] count = new int[str.length()][26];
        A: for (int i = 0; i < str.length(); i++) {
            int alpha = str.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    if (j == alpha) {
                        count[i][j] = 1;
                        continue A;
                    }
                }
                else {
                    if (j == alpha) {
                        count[i][j] = count[i - 1][j] + 1;
                    } else {
                        count[i][j] = count[i - 1][j];
                    }
                }
            }
        }

        // 누적합의 차이만큼 출력
        for (int i = 0; i < q; i++) {
            int alpha = question[i][0];
            int start = question[i][1];
            int end = question[i][2];

            int answer;
            if (start == 0) {
                answer = count[end][alpha];
            } else {
                answer = count[end][alpha] - count[start - 1][alpha];
            }
            bw.write(Integer.toString(answer));
            bw.write('\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

