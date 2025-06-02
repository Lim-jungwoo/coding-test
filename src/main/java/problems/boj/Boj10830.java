package problems.boj;

import java.util.*;
import java.io.*;

public class Boj10830 {
    static int[][] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int[][] answer = logic(A, B);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                bw.write(Integer.toString(answer[i][j]));
                if (j != answer[0].length - 1) bw.write(' ');
            }
            if (i != answer.length - 1) bw.write('\n');
        }


        br.close();
        bw.flush();
        bw.close();
    }

    static int[][] logic(int[][] m, long exp) {
        if (exp == 1) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[0].length; j++) {
                    m[i][j] %= 1000;
                }
            }
            return m;
        }
        int[][] half = logic(m, exp / 2);
        int[][] res = multiply(half, half);

        if (exp % 2 == 1) {
            res = multiply(res, A);
        }

        return res;
    }


    static int[][] multiply(int[][] m1, int[][] m2) {
        int a = m1.length;
        int b = m1[0].length;
        int c = m2[0].length;

        int[][] result = new int[a][c];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < b; k++) {
                    result[i][j] += m1[i][k] * m2[k][j] % 1000;
                    result[i][j] %= 1000;
                }
            }
        }
        return result;
    }

}
