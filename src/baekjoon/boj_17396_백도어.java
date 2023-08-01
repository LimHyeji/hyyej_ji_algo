package baekjoon;

import java.io.*;
import java.util.*;
/*
Long 범위인 것
visit 체크 위치
백트래킹
 */

public class boj_17396_백도어 {
    static int n, m;

    static class Node implements Comparable<Node>{
        int next;
        long cost;

        Node(int next, long cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost,o.cost);
        }
    }

    static ArrayList<Node>[] g;
    static boolean[] possible;
    static long[] distance;//수 범위 초과 고려

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        g = new ArrayList[n];
        possible = new boolean[n];
        distance=new long[n];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                possible[i] = true;
            }
            g[i] = new ArrayList<>();
            distance[i]=Long.MAX_VALUE;
        }
        possible[n - 1] = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            if (possible[a] && possible[b]) {
                g[a].add(new Node(b, cost));
                g[b].add(new Node(a, cost));
            }
        }

        out.write(String.valueOf(sol(0)));
        out.close();
        in.close();
    }
    static long sol(int start){
        distance[start]=0;
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(start,0));
        boolean[] visit=new boolean[n];

        while(!q.isEmpty()){
            Node temp=q.poll();
            int cur=temp.next;
            if(visit[cur]) continue; ///백트래킹
            visit[cur]=true;
            //System.out.println(cur+" -> cur");
            for(Node node:g[cur]){
                int next=node.next;
                long cost=node.cost;
                //if(visit[next]) continue;
                //System.out.println(next+" -> next");
                if(distance[next]>distance[cur]+cost){
                  //  System.out.println(next+" 방문 ");
                    distance[next]=distance[cur]+cost;
                    q.add(new Node(next,distance[next]));
                   //visit[next]=true;
                }
            }

        }

        if(distance[n-1]==Long.MAX_VALUE){
            return -1;
        }
        return distance[n-1];
    }
}