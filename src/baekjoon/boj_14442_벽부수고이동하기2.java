package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14442_벽부수고이동하기2 {
    static int n,m,k;
    static int[][] map;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static boolean[][][] visit;
    static class Node{
        int row,col,cnt;
        int k;
        Node(int row,int col,int cnt,int k){
            this.row=row;
            this.col=col;
            this.cnt=cnt;
            this.k=k;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            String input=in.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=input.charAt(j)-'0';
            }
        }

        visit=new boolean[k+1][n][m];
        out.write(String.valueOf(bfs()));
        out.close();
        in.close();

    }
    static int bfs(){
        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(0,0,1,0));
        if(map[0][0]==1){
            visit[1][0][0]=true;
        }
        else{
            visit[0][0][0]=true;
        }

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.row==n-1&&cur.col==m-1){
                return cur.cnt;
            }

            for(int dir=0;dir<4;dir++){
                int newR=dirR[dir]+cur.row;
                int newC=dirC[dir]+cur.col;

                if(newR<0||newR>=n||newC<0||newC>=m){
                    continue;
                }

                if(map[newR][newC]==1){
                    if(cur.k+1<=k&&!visit[cur.k+1][newR][newC]){
                        q.add(new Node(newR,newC,cur.cnt+1,cur.k+1));
                        visit[cur.k+1][newR][newC]=true;
                    }
                }
                else{
                    if(!visit[cur.k][newR][newC]){
                        q.add(new Node(newR,newC,cur.cnt+1,cur.k));
                        visit[cur.k][newR][newC]=true;
                    }
                }
            }
        }
        return -1;
    }
}
