package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1166_선물 {
    static long N, L, W, H;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        double left = 0;
        double right = Math.min(L, Math.min(W, H));
        double mid = 0;

        for (int i = 0; i < 10000; i++) {//while(left<right){
            mid = (left + right) / 2;

            if ((long) (L / mid) * (long) (W / mid) * (long) (H / mid) < N) right = mid;
            else left = mid;
        }

        out.write(String.valueOf(left));
        out.close();
        in.close();
    }
}
