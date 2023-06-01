package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01 {
    static int n, m;
    static Queue<Integer> q;
    static boolean[] truth;
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        q = new LinkedList<>();
        truth = new boolean[n + 1];
        visit = new boolean[m + 1];
        list = new ArrayList[m + 1];
        for (int i = 0; i < m + 1; i++) {
            list[i] = new ArrayList<>();
        }
        res = m;

        st = new StringTokenizer(in.readLine());
        int input = Integer.parseInt(st.nextToken());
        for (int i = 0; i < input; i++) {
            int temp = Integer.parseInt(st.nextToken());
            q.offer(temp);
            truth[temp] = true;
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(in.readLine());
            input = Integer.parseInt(st.nextToken());
            for (int j = 0; j < input; j++) {
                int temp = Integer.parseInt(st.nextToken());
                list[i].add(temp);
            }
        }

        sol();
        for(int i=1;i<visit.length;i++) {

        }
        System.out.println(res);

    }

    static void sol() {
        Queue<Integer> que = new LinkedList<>();

        while (!q.isEmpty() && !que.isEmpty()) {
            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int j = 1; j < m + 1; j++) {
                    for (int k : list[j]) {
                        if (cur == k && !visit[j]) {
                            que.offer(j);
                            visit[j] = true;
                        }
                    }
                }
            }

            while (!que.isEmpty()) {
                int cur = q.poll();

                for (int i : list[cur]) {
                    if (!truth[i]) {
                        q.offer(i);
                    }
                }
            }
        }
    }
}
