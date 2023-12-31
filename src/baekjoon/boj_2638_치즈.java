package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2638_치즈 {

    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    static int N,M;
    static int[][] map;
    static Queue<Node> cheeze;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static int count,result;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        map=new int[N][M];
        count=0;

        for(int i=0;i<N;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]>0) count++;
            }
        }

        cheeze=new ArrayDeque<>();
        result=0;

        in.close();
    }

    static void solution(){
        while(count>0){
            Queue<Node> q=new ArrayDeque<>();
            boolean[][] visit=new boolean[N][M];

            q.add(new Node(0,0));
            visit[0][0]=true;

            while(!q.isEmpty()){
                Node cur=q.poll();

                for(int dir=0;dir<4;dir++){
                    int newR=dirR[dir]+cur.row;
                    int newC=dirC[dir]+cur.col;

                    if(newR<0||newR>=N||newC<0||newC>=M||visit[newR][newC]) continue;

                    if(map[newR][newC]==1){
                        cheeze.add(new Node(newR,newC));
                        map[newR][newC]++;
                    }
                    else if(map[newR][newC]>1){
                        map[newR][newC]++;
                    }
                    else if(map[newR][newC]==0){
                        visit[newR][newC]=true;
                        q.add(new Node(newR,newC));
                    }
                }
            }

            for(Node cur:cheeze){
                if(map[cur.row][cur.col]>=3){
                    map[cur.row][cur.col]=0;
                    count--;
                }
                else{
                    map[cur.row][cur.col]=1;
                }
            }
            cheeze.clear();
            result++;

            //printMap();
        }
    }

    static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(result));
        out.close();
    }

    static void printMap(){
        for(int[] arr:map) System.out.println(Arrays.toString(arr));
        System.out.println();
    }

}
