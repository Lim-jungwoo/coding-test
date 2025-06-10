package problems.books.codingtest_java;

import java.io.*;
import java.util.*;

public class p21 {
    public static void main(String[] args) throws IOException {
        String[] records = new String[] {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"
        };
        String[] results = new String[] {
                "Prodo님이 들어왔습니다.",
                "Ryan님이 들어왔습니다.",
                "Prodo님이 나갔습니다.",
                "Prodo님이 들어왔습니다."
        };

        String[] result = solution(records);
        System.out.println(Arrays.toString(result));
    }

    static String[] solution(String[] records) {
        // 한국어 출력 저장
        HashMap<String, String> korean = new HashMap<>();
        korean.put("Enter", "님이 들어왔습니다.");
        korean.put("Leave", "님이 나갔습니다.");

        // 아이디와 닉네임 저장
        HashMap<String, String> uidNicknameMap = new HashMap<>();
        for (int i = 0; i < records.length; i++) {
            String[] line = records[i].split(" ");
            String cmd = line[0];
            if (Objects.equals(cmd, "Leave")) continue;
            String uid = line[1];
            String nickname = line[2];

            uidNicknameMap.put(uid, nickname);
        }

        // 결과
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < records.length; i++) {
            String[] line = records[i].split(" ");
            String cmd = line[0];
            if (Objects.equals(cmd, "Change")) continue;
            String uid = line[1];
            String nickname = uidNicknameMap.get(uid);

            result.add(nickname + korean.get(cmd));
        }

        return result.toArray(new String[0]);
    }
}