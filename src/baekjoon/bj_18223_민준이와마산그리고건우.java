package baekjoon;

import java.io.*;
import java.util.*;

public class bj_18223_민준이와마산그리고건우 {
    static int v,e,p;
    static class Node implements Comparable<Node> {
        int to,cost;
        Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost,o.cost);
        }
    }
    static ArrayList<Node>[] g;

    public static void main(String[] args) throws IOException {
        BufferedReader in= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        p=Integer.parseInt(st.nextToken())-1;

        g=new ArrayList[v];
        for(int i=0;i<v;i++){
            g[i]=new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            st=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(st.nextToken())-1;
            int to=Integer.parseInt(st.nextToken())-1;
            int cost=Integer.parseInt(st.nextToken());
            g[from].add(new Node(to,cost));
            g[to].add(new Node(from,cost));
        }

        int save=sol(0,p)+sol(p,v-1);
        int not_save=sol(0,v-1);
        //System.out.println(save+" , "+not_save);
        out.write(save<=not_save?"SAVE HIM":"GOOD BYE");
        out.close();
        in.close();
    }

    static int sol(int start, int end){
        int[] distance=new int[v];
        for(int i=0;i<v;i++){
            distance[i]=Integer.MAX_VALUE;//초기화 반드시 하기
        }
        PriorityQueue<Node> pq=new PriorityQueue<>();
        distance[start]=0;//시작점에서의 거리 0으로 세팅하기
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            if(distance[cur.to]<cur.cost) continue;

            for(Node next:g[cur.to]){
                if(distance[next.to]>next.cost+distance[cur.to]){//next임을 잊지 말기
                    distance[next.to]=next.cost+distance[cur.to];
                    pq.add(new Node(next.to,distance[next.to]));
                }
            }
        }
        //System.out.println(Arrays.toString(distance));
        return distance[end];
    }

}
