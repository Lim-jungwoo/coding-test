package problems.boj;

import java.util.*;
import java.io.*;

public class Boj12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int index = findIndex(list, nums[i]);

            if (index == list.size()) {
                list.add(nums[i]);
            }
            else {
                list.set(index, nums[i]);
            }
        }

        bw.write(Integer.toString(list.size()));

        br.close();
        bw.flush();
        bw.close();
    }

    // 이분 탐색으로 key를 넣을 위치를 찾는다.
    static int findIndex(ArrayList<Integer> list, int key) {
        int left = 0;
        int right = list.size() - 1;
        int index = list.size();

        while (left <= right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= key) {
                index = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }

        return index;
    }
}