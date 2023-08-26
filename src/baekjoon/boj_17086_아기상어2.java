package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17086_아기상어2 {
    static int n,m;
    static int[][] map;
    static int[] dirR={-1,1,0,0,-1,-1,1,1};
    static int[] dirC={0,0,-1,1,-1,1,-1,1};
    static int res;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==0){
                    visit=new boolean[n][m];
                    bfs(i,j);
                }
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
    static class Node{
        int row,col,cnt;
        Node(int row,int col,int cnt){
            this.row=row;
            this.col=col;
            this.cnt=cnt;
        }
    }
    static void bfs(int row,int col){
        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(row,col,0));
        visit[row][col]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();
            if(map[cur.row][cur.col]==1){
                res=Math.max(res,cur.cnt);
                return;
            }

            for(int dir=0;dir<8;dir++){
                int newR=dirR[dir]+cur.row;
                int newC=dirC[dir]+cur.col;

                if(newR<0||newR>=n||newC<0||newC>=m||visit[newR][newC]) continue;

                q.add(new Node(newR,newC,cur.cnt+1));
                visit[newR][newC]=true;
            }
        }
    }
}
