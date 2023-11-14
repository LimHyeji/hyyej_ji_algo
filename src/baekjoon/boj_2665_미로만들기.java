package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * boolean visit[n][n][n*n]
 * Node(row,col,cnt), boolean visit[n][n]
 * int visit[n][n]
 */
public class boj_2665_미로만들기 {
    static int n;
    static int[][] map;
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static int [][] visited;
    static int res;

    public static void main(String[] args) throws IOException {
        init();
        search();
        print();
    }

    public static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());

        map=new int[n][n];
        visited=new int[n][n];
        for(int i=0;i<n;i++){
            String input=in.readLine();
            for(int j=0;j<n;j++){
                map[i][j]=input.charAt(j)-'0';
            }
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }

        res=Integer.MAX_VALUE;
        in.close();
    }

    public static void search(){
        Queue<Node> pq=new ArrayDeque<>();
        pq.add(new Node(0,0));
        visited[0][0]=0;

        while(!pq.isEmpty()){
            Node cur=pq.poll();
            //System.out.println(cur.row+" "+cur.col+" "+visited[cur.row][cur.col]);

            for(int dir=0;dir<4;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];

                if(!indexOut(newR,newC)){
                    if(map[newR][newC]==0){
                        if(visited[cur.row][cur.col]+1<visited[newR][newC]){
                            pq.add(new Node(newR,newC));
                            visited[newR][newC]=visited[cur.row][cur.col]+1;
                        }
                    }
                    else {
                        if (visited[cur.row][cur.col] < visited[newR][newC]) {
                            pq.add(new Node(newR, newC));
                            visited[newR][newC] = visited[cur.row][cur.col];
                        }
                    }

                }
            }

        }
    }

    public static boolean indexOut(int row,int col){
        if(row<0||row>=n||col<0||col>=n) return true;
        return false;
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(visited[n-1][n-1]));
        out.close();
    }
}
