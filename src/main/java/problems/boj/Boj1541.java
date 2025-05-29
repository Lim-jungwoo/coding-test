package problems.boj;

import java.io.*;
import java.util.*;

public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        ArrayList<Integer> numList = new ArrayList<>();
        int minusIndex = 0;
        for (int i = 0; i < str.length();) {
            StringBuilder num = new StringBuilder();
            if (str.charAt(i) == '-') {
                if (minusIndex == 0)
                    minusIndex = numList.size();
                i++;
                continue;
            }
            else if (str.charAt(i) == '+') {
                i++;
                continue;
            }
            while (str.charAt(i) != '-' && str.charAt(i) != '+') {
                num.append(str.charAt(i));
                i++;
                if (i == str.length()) break;
            }
            numList.add(Integer.parseInt(num.toString()));
        }

        int result = 0;
        for (int i = 0; i < numList.size(); i++) {
            if (minusIndex != 0 && i >= minusIndex)
                result -= numList.get(i);
            else
                result += numList.get(i);
        }

        System.out.println(Integer.toString(result));

        bw.flush();
        bw.close();
        br.close();
    }
}