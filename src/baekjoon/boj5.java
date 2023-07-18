package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj5 {
    static char[] input;
    static StringBuilder max;
    static StringBuilder min;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        input = in.readLine().toCharArray();

        max = new StringBuilder();
        min = new StringBuilder();

        int cntM = 0;
        for (char c : input) {
            if (c == 'K') {
                max.append("5");
                for (int i = 0; i < cntM; i++) {
                    max.append("0");

                }
                if (cntM >= 1) {
                    min.append("1");
                    for (int i = 1; i < cntM; i++) {
                        min.append("0");
                    }

                }
                min.append("5");
                cntM = 0;
            } else {
                cntM++;
            }
        }
        if (cntM > 0) {
            for (int i = 0; i < cntM; i++) {
                max.append("1");
            }

            min.append("1");
            for (int i = 1; i < cntM; i++) {
                min.append("0");
            }
        }

        System.out.println(max.toString());
        System.out.println(min.toString());
    }
}
