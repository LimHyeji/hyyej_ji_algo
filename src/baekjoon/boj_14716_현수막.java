package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14716_현수막 {
    static int[] dirR={-1,1,0,0,-1,-1,1,1};
    static int[] dirC={0,0,-1,1,-1,1,-1,1};
    static int m,n;
    static int[][] map;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        map=new int[m][n];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        res=0;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(map[i][j]==1){
//                    System.out.println("bfs call");
//                    bfs(i,j);
//                    System.out.println("dfs call");
                    dfs(i,j);
                    res++;
                }
            }
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static void bfs(int i,int j){
        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(i,j));
        map[i][j]=-1;
        while(!q.isEmpty()){
            Node cur=q.poll();
            for(int dir=0;dir<8;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];
                if(newR<0||newR>=m||newC<0||newC>=n||map[newR][newC]!=1)
                    continue;
                q.add(new Node(newR,newC));
               map[newR][newC]=-1;
            }
        }
    }

    static void dfs(int i,int j){
        //System.out.println(i+", "+j+" 사라짐");
        map[i][j]=-1;

        for(int dir=0;dir<8;dir++){
            int newR=i+dirR[dir];
            int newC=j+dirC[dir];
            if(newR<0||newR>=m||newC<0||newC>=n||map[newR][newC]!=1)
                continue;
                dfs(newR,newC);
        }
    }
}
