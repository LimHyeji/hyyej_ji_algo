package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj8 {
    static int n, m;
    static ArrayList<Integer>[] g;
    static int max;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        g = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            g[from].add(to);
        }

        max = 0;
        list = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            sol(i);
        }
        for (int cur : list) {
            System.out.print(cur + " ");
        }
    }

    static void sol(int num) {
        int cnt = 0;
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n + 1];

        q.add(num);
        visit[num] = true;
        cnt++;

        while (!q.isEmpty()) {
            int cur = q.poll();
//			System.out.print(cur+" ");
            for (int next : g[cur]) {
                if (!visit[next]) {
                    q.add(next);
                    cnt++;
                    visit[next] = true;
                }
            }
        }

        if (max < cnt) {
            list.clear();
            max = cnt;
            list.add(num);
        } else if (max == cnt) {
            list.add(num);
        }
//		System.out.print("->"+cnt);
//		System.out.println();
    }
}
