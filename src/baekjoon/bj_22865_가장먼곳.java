package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_22865_가장먼곳 {
    /*
     * n개 땅 a,b,c (a,b,c 중 가까운 거리) 중 최대값 m개 도로 양방향 그래프
     */
    static int n, m;
    static int[] person;
    static int[] dist;
    static class Edge implements Comparable<Edge>
    {
        int end;
        int w;

        Edge(int end, int w) {
            this.end = end;
            this.w = w;
        }

        @Override
        public int compareTo(bj_22865_가장먼곳.Edge o) {
            return Integer.compare(this.w, o.w);
        }

    }

    static ArrayList<Edge>[] g;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(in.readLine());
        person = new int[3];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < 3; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        g = new ArrayList[n + 1];
        dist=new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
        }
        m = Integer.parseInt(in.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[from].add(new Edge(to, w));
            g[to].add(new Edge(from, w));
        }

        int res = Integer.MIN_VALUE;
        int idx = -1;
        for (int i = 1; i < n + 1; i++) {
            int temp = Integer.MAX_VALUE;
            for (int p = 0; p < 3; p++) {
                dist=new int[n+1];
                for (int j = 0; j < n + 1; j++) {
                    dist[j]=Integer.MAX_VALUE;
                }
                dijkstra(person[p]);
                temp=Math.min(temp,dist[n]);
            }
            if (res < temp) {
                res = temp;
                idx = i;
            }
        }
        System.out.println(idx);
    }


    public static void dijkstra(int start) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        boolean[] check = new boolean[n + 1];
        queue.add(new Edge(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Edge curNode = queue.poll();
            int cur = curNode.end;

            if (check[cur] == true)
                continue;
            check[cur] = true;

            for (Edge node : g[cur]) {
                if (dist[node.end] > dist[cur] + node.w) {
                    dist[node.end] = dist[cur] + node.w;
                    queue.add(new Edge(node.end, dist[node.end]));
                }
            }
        }
    }
}
