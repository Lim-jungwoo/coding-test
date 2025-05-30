package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1992 {
    static int[][] arr;
    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j + 1] = str.charAt(j) - '0';
            }
        }

        recursion(N, 1, 1);
        bw.write(answer.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void recursion(int n, int si, int sj) {
        if (n < 0) return;

        int num = arr[si][sj];
        for (int i = si; i < n + si; i++) {
            for (int j = sj; j < n + sj; j++) {
                if (num != arr[i][j]) {
                    answer.append('(');
                    int size = n / 2;
                    recursion(size, si, sj);
                    recursion(size, si, sj + size);
                    recursion(size, si + size, sj);
                    recursion(size, si + size, sj + size);
                    answer.append(')');
                    return;
                }
            }
        }

        answer.append(Integer.toString(num));
    }
}