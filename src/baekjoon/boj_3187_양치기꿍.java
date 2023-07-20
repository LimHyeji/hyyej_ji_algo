package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_3187_양치기꿍 {
    static int r,c;
    static char[][] map;

    static int v,k;
    static boolean[][] visit;
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringBuilder str=new StringBuilder();
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        map=new char[r][c];
        for(int i=0;i<r;i++){
            String input=in.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=input.charAt(j);
            }
        }
        v=0;k=0;
        visit=new boolean[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]=='v'||map[i][j]=='k'){
                    bfs(i,j);
                }
            }
        }
        str.append(k).append(" ").append(v);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void bfs(int row,int col){
        Queue<Node> q=new ArrayDeque<>();
        int v_cnt=0;
        int k_cnt=0;
        q.add(new Node(row,col));
        visit[row][col]=true;
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(map[cur.row][cur.col]=='v'){
                v_cnt++;
            }
            else if(map[cur.row][cur.col]=='k'){
                k_cnt++;
            }
            map[cur.row][cur.col]='.';
            for(int dir=0;dir<4;dir++){
                int newR=dirR[dir]+cur.row;
                int newC=dirC[dir]+cur.col;
                if(newR<0||newR>=r||newC<0||newC>=c||visit[newR][newC]||map[newR][newC]=='#'){
                    continue;
                }
                q.add(new Node(newR,newC));
                visit[newR][newC]=true;
            }
        }
        if(v_cnt>=k_cnt){
            v+=v_cnt;
        }
        else{
            k+=k_cnt;
        }
    }
}
