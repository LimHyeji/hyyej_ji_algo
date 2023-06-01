package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_16562_친구비 {
    /*
     * n명,Ai만큼의 돈-> 한달, 총 k원, 친구의 친구, 최소비용
     */
    static int n, m, k;
    static int[] cost;
    static int[] par;

    static int find(int num) {
        if (par[num] == num)
            return num;
        else
            return par[num] = find(par[num]);
    }

    static boolean[] visit;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        cost = new int[n + 1];

        st = new StringTokenizer(in.readLine());
        for (int i = 1; i < n + 1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        par = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            par[i] = i;
        }

        res = 0;
        for (int i = 1; i < m + 1; i++) {
            st = new StringTokenizer(in.readLine());
            int a = find(Integer.parseInt(st.nextToken()));
            int b = find(Integer.parseInt(st.nextToken()));

            if (a < b) {
                par[b] = a;
            } else if (a > b) {
                par[a] = b;
            }
        }

        visit = new boolean[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (!visit[find(i)]) {
                res += cost[i];
                visit[find(i)] = true;
            } else {
                if (cost[i] < cost[find(i)]) {
                    res += cost[i];
                    res -= cost[find(i)];
                    cost[find(i)] = cost[i];
                }
            }
        }
        if (res <= k) {
            out.write(String.valueOf(res));
        } else {
            out.write("Oh no");
        }

        out.close();
        in.close();
    }
}
