package baekjoon;

import javax.swing.plaf.basic.BasicButtonListener;
import java.io.*;
import java.util.*;

public class boj_5972_택배배송 {
    static class Node implements Comparable<Node> {
        int next, cost;
        Node(int next,int cost){
            this.next=next;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
    static int n,m;
    static ArrayList<Node>[] g;
    static PriorityQueue<Node> pq;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        g=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int cost=Integer.parseInt(st.nextToken());
            g[a].add(new Node(b,cost));
            g[b].add(new Node(a,cost));
        }

        pq=new PriorityQueue<>();
        distance=new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);

        sol();

        out.write(String.valueOf(distance[n-1]));
        out.close();
        in.close();
    }

    static void sol(){
        distance[0]=0;
        pq.add(new Node(0,0));

        while(!pq.isEmpty()){
            Node cur=pq.poll();

            int next=cur.next;

            for(Node node:g[next]){
                int nnext=node.next;
                int ncost=node.cost;
                if(distance[nnext]>distance[next]+ncost){
                    distance[nnext]=distance[next]+ncost;
                    pq.add(new Node(nnext,distance[nnext]));
                }
            }
        }

    }
}
