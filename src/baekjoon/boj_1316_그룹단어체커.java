package baekjoon;

import java.io.*;

public class boj_1316_그룹단어체커 {
    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(in.readLine());

        res = 0;
        for (int i = 0; i < N; i++) {
            String input = in.readLine();
            if (check(input)) res++;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    public static boolean check(String word) {
        boolean[] visit = new boolean[26];
        char prev = word.charAt(0);

        for (int i = 1; i < word.length(); i++) {
            char cur = word.charAt(i);

            if (prev != cur) {
                if (visit[cur - 'a']) return false;
                visit[prev - 'a'] = true;
                prev = cur;
            }
        }

        return true;
    }
}
