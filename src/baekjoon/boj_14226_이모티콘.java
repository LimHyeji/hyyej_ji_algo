package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class boj_14226_이모티콘 {
    static int s;
    static class Node implements Comparable<Node>{
        int monitor, clipboard;
        int cnt;

        Node(int monitor, int clipboard, int cnt) {
            this.monitor = monitor;
            this.clipboard = clipboard;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt,o.cnt);
        }
    }
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        s=Integer.parseInt(in.readLine());

        out.write(String.valueOf(bfs(1)));
        out.close();
        in.close();
    }

    static int bfs(int start){
        PriorityQueue<Node> q=new PriorityQueue<>();
        q.add(new Node(1,0,0));
        visit=new boolean[2001];
        visit[1]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.monitor==s){
                return cur.cnt;
            }
            //if(!visit[cur.monitor]) {
                q.add(new Node(cur.monitor, cur.monitor, cur.cnt + 1));
              //  visit[cur.monitor]=true;
            //}
            if(!visit[cur.monitor+cur.clipboard]&&cur.monitor+ cur.clipboard<=2000) {
                q.add(new Node(cur.monitor + cur.clipboard, cur.clipboard, cur.cnt + 1));
                visit[cur.monitor+ cur.clipboard]=true;
            }
            if(cur.monitor-1>=0&&!visit[cur.monitor-1]) {
                q.add(new Node(cur.monitor - 1, cur.clipboard,cur.cnt+1));
                visit[cur.monitor-1]=true;
            }
        }
        return -1;
    }
}
