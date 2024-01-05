package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16960_스위치와램프 {
    static int n, m;
    static List<Integer> g[];
    static int[] lamp;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        lamp = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            int size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                int temp = Integer.parseInt(st.nextToken()) - 1;
                g[i].add(temp);
                lamp[temp]++;
            }
        }

        res = 0;
        for (int i = 0; i < n; i++) {
            for (int num : g[i]) {
                lamp[num]--;
            }

            boolean success = true;
            for (int j = 0; j < m; j++) {
                if (lamp[j] == 0) {
                    success = false;
                    break;
                }
            }

            if (success) {
                res = 1;
                break;
            }

            for (int num : g[i]) {
                lamp[num]++;
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
