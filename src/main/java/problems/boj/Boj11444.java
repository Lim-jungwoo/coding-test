package problems.boj;

import java.util.*;
import java.io.*;

public class Boj11444 {
    static long MOD = 1000000007;
    static long[][] arr = new long[][] {
            {1, 1},
            {1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());

        long result = fivonachi(N);
        bw.write(Long.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static long fivonachi(long n) {
        long[][] res = matrixPower(arr, n);
        return res[0][1];
    }

    static long[][] matrixPower(long[][] m, long exp) {
        if (exp == 1) return m;
        long[][] half = matrixPower(m, exp / 2);
        long[][] res = multiply(half, half);
        if (exp % 2 == 1) {
            res = multiply(res, arr);
        }

        return res;
    }

    static long[][] multiply(long[][] m1, long[][] m2) {
        long[][] result = new long[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j] % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
