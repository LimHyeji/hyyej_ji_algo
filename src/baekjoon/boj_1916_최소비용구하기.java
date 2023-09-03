package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1916_최소비용구하기 {
    static int n,m;
    static class Node implements Comparable<Node>{
        int next; int cost;
        Node(int next, int cost){
            this.next=next;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
    static ArrayList<Node>[] g;
    static int[] distance;
    static int start,end;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        m=Integer.parseInt(in.readLine());

        g=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            g[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            g[from].add(new Node(to,cost));
        }
        st=new StringTokenizer(in.readLine());
        start=Integer.parseInt(st.nextToken());
        end=Integer.parseInt(st.nextToken());

        distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        out.write(String.valueOf(sol()));
        out.close();
        in.close();
    }

    static int sol(){
        PriorityQueue<Node> pq=new PriorityQueue<>();
        distance[start]=0;
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node temp=pq.poll();

            int next=temp.next;
            int cost=temp.cost;

            if(next==end) return distance[next];

            for(Node nextNode:g[next]){
                int nnext=nextNode.next;
                int newDistance=distance[next]+nextNode.cost;
                if(distance[nnext]>newDistance){
                    distance[nnext]=newDistance;
                    pq.add(new Node(nnext,distance[nnext]));
                }
            }
        }
        return 0;
    }
}
