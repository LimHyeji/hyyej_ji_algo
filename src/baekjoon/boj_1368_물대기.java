package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1368_물대기 {
    static int n;
    static int[] w;
    static ArrayList<Edge> start;
    static class Edge implements Comparable<Edge> {
        int next,cost;
        Edge(int next,int cost){
            this.next=next;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
    static ArrayList<Edge>[] g;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());

        w=new int[n];
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            w[i]=Integer.parseInt(in.readLine());
            min=Math.min(min,w[i]);
        }

        start=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(min==w[i]) start.add(new Edge(i,w[i]));
        }

        g=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                int temp=Integer.parseInt(st.nextToken());
                if(i==j) continue;
                g[i].add(new Edge(j,temp));
            }
        }

        res=Integer.MAX_VALUE;
        for(int i=0;i<start.size();i++){
            sol(start.get(i));
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

    public static void sol(Edge start){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean[] visit=new boolean[n];
        int sum=0;

        pq.add(start);

        while(!pq.isEmpty()){
            Edge cur=pq.poll();

            if(visit[cur.next]) continue;
            visit[cur.next]=true;
            sum+=cur.cost;
            System.out.println(cur.next);

            for(Edge e:g[cur.next]){
                if(visit[e.next]) continue;
                pq.add(new Edge(e.next,w[e.next]));
                pq.add(e);
            }
        }
        res=Math.min(res,sum);
    }
}
