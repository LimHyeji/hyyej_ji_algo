package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_22865_가장먼곳 {
    static int n,m;
    static class Node implements Comparable<Node>{
        int to;
        int cost;
        Node(int to,int cost){
            this.to=to;
            this.cost=cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int a,b,c;
    static ArrayList<Node>[] list;
    static long dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        list=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            list[i]=new ArrayList<>();
        }

        st=new StringTokenizer(in.readLine());
        a= Integer.parseInt(st.nextToken());
        b= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());

        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,cost));
            list[to].add(new Node(from,cost));
        }

        long []dist1 = dijkstra(a);
        long []dist2 = dijkstra(b);
        long []dist3 = dijkstra(c);

        int vertex = 0;
        long compareDistance = 0;
        for (int i=1; i<=n; i++) {

            long minDistance = Math.min(dist1[i],Math.min(dist2[i],dist3[i]));

            if (minDistance == compareDistance) continue;

            if (minDistance > compareDistance) {
                compareDistance = minDistance;
                vertex = i;
            }
        }

        System.out.println(vertex);


/*
n개 땅
각각 "a,b,c 중 가장 가까운 거리"의 최대값
 */


    }

    private static long[] dijkstra(int start) {

        long[] dist = new long[n+1];

        for (int i= 1; i<=n; i++) dist[i] = Long.MAX_VALUE;

        dist[start] = 0; // 자기 자신은 방문하지 않으므로 0부터 시작.
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 최단거리를 찾기 위한 pq 선언.

        pq.add(new Node(start,0)); // 시작 정점의 번호와 cost를 0으로 넣고 삽입

        while(!pq.isEmpty()) {

            Node temp = pq.poll();

            int cur = temp.to; // 현재 위치
            int distance = temp.cost; // 현재 위치까지 오는데 걸린 비용

            if (dist[cur] < distance) continue; // 이미 최단경로보다 큰 값을 가지고 있으면 continue

            for (int i = 0; i < list[cur].size(); i++) { // 인접한 정점들의 개수에 대하여

                int nxt_distance = distance + list[cur].get(i).cost; // 다음 정점까지 가는데 드는 비용 계산
                int nxt = list[cur].get(i).to; // 다음 위치

                if (dist[nxt] > nxt_distance) { // 다음 정점까지 가는데 드는 비용이 이미 저장되있는 비용보다 작은 경우
                    dist[nxt] = nxt_distance; // 갱신
                    pq.add(new Node(nxt,nxt_distance)); // 큐 삽입
                }

            }
        }

        return dist;
    }
}
