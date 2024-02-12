package baekjoon;

import java.io.*;
import java.util.*;

public class boj_1202_보석도둑 {
    static int N,K;
    static class Node implements Comparable<Node>{
        int M,V;
        Node(int M,int V){
            this.M=M;
            this.V=V;
        }

        @Override
        public int compareTo(Node o) {
            if(this.M==o.M) return Integer.compare(o.V,this.V);
            return Integer.compare(this.M,o.M);
        }
    }
    static List<Node> nodes;
    static PriorityQueue<Integer> pq;
    static List<Integer> bags;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        nodes=new ArrayList<>();
        for(int i=0;i<N;i++){
            st=new StringTokenizer(in.readLine());
            int M=Integer.parseInt(st.nextToken());
            int V=Integer.parseInt(st.nextToken());
            nodes.add(new Node(M,V));
        }

        bags=new ArrayList<>();
        for(int i=0;i<K;i++){
            bags.add(Integer.parseInt(in.readLine()));
        }

        Collections.sort(nodes);
        Collections.sort(bags);

        result=0;
        pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0,j=0;i<bags.size();i++){
            int C=bags.get(i);
            while(j<nodes.size()&&nodes.get(j).M<=C){
                pq.add(nodes.get(j++).V);
            }

            if(!pq.isEmpty()) result+=pq.poll();
        }

        System.out.println(result);
    }
}
