package problems.boj;

import java.io.*;
import java.util.*;

public class Boj10172 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        sb.append("|\\_/|\n" +
                "|q p|   /}\n" +
                "( 0 )\"\"\"\\\n" +
                "|\"^\"`    |\n" +
                "||_/=\\\\__|");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}