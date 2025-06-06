package problems.boj;

import java.io.*;
import java.util.*;

public class Boj2143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> ASumList = makeSumList(A);
        ArrayList<Integer> BSumList = makeSumList(B);
        // B의 부분합 목록은 오름차순으로 정렬
        BSumList.sort(Comparator.naturalOrder());

        long count = 0;
        for (int i = 0; i < ASumList.size(); i++) {
            int target = T - ASumList.get(i);
            int lowerBound = lowerBound(BSumList, target);
            int upperBound = upperBound(BSumList, target);
            count += upperBound - lowerBound;
        }

        bw.write(Long.toString(count));

        br.close();
        bw.flush();
        bw.close();
    }

    // 부분합 배열을 만든다.
    static ArrayList<Integer> makeSumList(int[] numList) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numList.length; i++) {
            int sum = 0;
            for (int j = i; j < numList.length; j++) {
                sum += numList[j];
                list.add(sum);
            }
        }
        return list;
    }

    // 처음 target값이 되는 index값을 찾는다.
    static int lowerBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    // 처음 target값보다 커지는 index값을 찾는다.
    static int upperBound(ArrayList<Integer> list, int target) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}