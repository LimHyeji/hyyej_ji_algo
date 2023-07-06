package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_1926_그림 {
    static int n,m;
    static int[][] map;
    static int cnt,area;

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        cnt=0;
        area=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    area=Math.max(area,bfs(i,j));
                    cnt++;
                }
            }
        }

        str.append(cnt).append("\n").append(area);
        out.write(str.toString());
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
    static int bfs(int i,int j){
        int area=0;

        Queue<Node> q= new ArrayDeque<>();
        q.add(new Node(i,j));
        map[i][j]=-1;
        area++;

        while(!q.isEmpty()){
            Node cur=q.poll();

            for(int dir=0;dir<4;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];

                if(newR<0||newR>=n||newC<0||newC>=m||map[newR][newC]!=1)
                    continue;

                q.add(new Node(newR,newC));
                map[newR][newC]=-1;
                area++;
            }
        }
                return area;
    }
}
