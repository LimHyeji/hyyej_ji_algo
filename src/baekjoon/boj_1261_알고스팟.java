package baekjoon;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class boj_1261_알고스팟 {
    static int m,n;
    static int[][] map;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static class Node implements Comparable<Node>{
        int row,col;
        int cnt;
        Node(int row,int col,int cnt){
            this.row=row;
            this.col=col;
            this.cnt=cnt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cnt,o.cnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            String input=in.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=input.charAt(j)-'0';
            }
        }
        out.write(String.valueOf(bfs()));
        out.close();
        in.close();

    }
    static int bfs(){
        PriorityQueue<Node> q=new PriorityQueue<>();
        boolean[][] visit=new boolean[n][m];
        q.add(new Node(0,0,0));
        visit[0][0]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.row==n-1&&cur.col==m-1){
                return cur.cnt;
            }

            for(int dir=0;dir<4;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];

                if(newR<0||newR>=n||newC<0||newC>=m||visit[newR][newC]){
                    continue;
                }

                if(map[newR][newC]==1){
                    visit[newR][newC]=true;
                        q.add(new Node(newR, newC, cur.cnt+1));
                }
                else{
                    visit[newR][newC]=true;
                    q.add(new Node(newR,newC,cur.cnt));
                }
            }
        }
        return 0;
    }
}
