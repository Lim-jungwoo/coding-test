package problems.boj;

import java.util.*;
import java.io.*;

public class Boj11401 {
    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] factorial = new long[N + 1];
        factorial[0] = factorial[1] = 1;
        for (int i = 1; i <= N; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
        }

        long numerator = factorial[N];
        long denominator = (factorial[N - K] * factorial[K]) % mod;
        long result = numerator * modInverse(denominator) % mod;

        bw.write(Long.toString(result));

        br.close();
        bw.flush();
        bw.close();
    }

    static long modInverse(long x) {
        return modPow(x, mod - 2);
    }

    static long modPow(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
