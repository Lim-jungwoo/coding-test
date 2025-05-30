package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        bw.write(Long.toString(recursion(A, B, C)));

        bw.flush();
        bw.close();
        br.close();
    }

    static long recursion(int a, int b, int c) {
        if (b == 0) return 1;
        if (b == 1) return a % c;
        long half = recursion(a, b / 2, c);

        if (b % 2 == 0) {
            return (half * half) % c;
        } else {
          return ((half * half % c) * a) % c;
        }
    }
}