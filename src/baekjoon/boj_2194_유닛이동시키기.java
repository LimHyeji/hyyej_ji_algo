package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2194_유닛이동시키기 {
    static int n,m,a,b,k;
    static boolean[][] map;
    static class Node{
        int row,col,cnt;
        Node(int row,int col,int cnt){
            this.row=row;
            this.col=col;
            this.cnt=cnt;
        }
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static Node start;
    static Node end;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        a=Integer.parseInt(st.nextToken());
        b=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        map=new boolean[n][m];

        for(int i=0;i<k;i++){
            st=new StringTokenizer(in.readLine());
            int row=Integer.parseInt(st.nextToken())-1;
            int col=Integer.parseInt(st.nextToken())-1;
            map[row][col]=true;
        }

            st=new StringTokenizer(in.readLine());
            int row=Integer.parseInt(st.nextToken())-1;
            int col=Integer.parseInt(st.nextToken())-1;
            start=new Node(row,col,0);

            st=new StringTokenizer(in.readLine());
            row=Integer.parseInt(st.nextToken())-1;
            col=Integer.parseInt(st.nextToken())-1;
            end=new Node(row,col);

            res=Integer.MAX_VALUE;
            bfs();
            if(res==Integer.MAX_VALUE) res=-1;
            out.write(String.valueOf(res));
            out.close();
            in.close();
    }

    static void bfs(){
        Queue<Node> q=new ArrayDeque<>();
        boolean[][] visit=new boolean[n][m];
        q.add(start);
        visit[start.row][start.col]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur.row==end.row&&cur.col==end.col){
                res=Math.min(res,cur.cnt);
                return;
            }

            for(int dir=0;dir<4;dir++){
                int newR=dirR[dir]+cur.row;
                int newC=dirC[dir]+cur.col;

                if(newR<0||newR>=n||newC<0||newC>=m||visit[newR][newC]||map[newR][newC])
                    continue;

                if(check(newR,newC)){
                    q.add(new Node(newR,newC,cur.cnt+1));
                    visit[newR][newC]=true;
                }
            }
        }


    }

    static boolean check(int row,int col){

        for(int i=row;i<row+a;i++){
            for(int j=col;j<col+b;j++){
                if(i<0||i>=n||j<0||j>=m||map[i][j])
                    return false;
            }
        }

        return true;
    }
}
