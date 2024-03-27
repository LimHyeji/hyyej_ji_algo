package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1049_기타줄 {
    static int N, M, pack, unit;

    public static void main(String[] args) throws IOException {
        input();
        solution();
        output();
    }

    public static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pack = Integer.MAX_VALUE;
        unit = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            pack = Math.min(pack, Integer.parseInt(st.nextToken()));
            unit = Math.min(unit, Integer.parseInt(st.nextToken()));
        }
        in.close();
    }

    public static void solution() {
        pack = pack * (N / 6) + Math.min(pack, (N % 6) * unit);
        unit = unit * N;
    }

    public static void output() throws IOException {
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(Math.min(pack, unit)));
        out.close();
    }
}
