package baekjoon;

import java.io.*;
import java.util.*;

public class boj_18405_경쟁적전염 {
    static int N,K;
    static int[][] map;
    static boolean[][] visit;
    static int S,X,Y;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static class Virus implements Comparable<Virus>{
        int num,row,col;
        Virus(int num,int row,int col){
            this.num=num;
            this.row=row;
            this.col=col;
        }

        @Override
        public int compareTo(Virus o) {
            return Integer.compare(this.num,o.num);
        }
    }
    static PriorityQueue<Virus> q;

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        print();
    }

    public static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        map=new int[N][N];
        visit=new boolean[N][N];
        q=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]>0){
                    visit[i][j]=true;
                    q.add(new Virus(map[i][j],i,j));
                }
            }
        }

        st=new StringTokenizer(in.readLine());
        S=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken())-1;
        Y=Integer.parseInt(st.nextToken())-1;

        in.close();
    }

    public static void bfs(){
        Queue<Virus> tempQ=new ArrayDeque<>();

        while(!q.isEmpty()&&S>0){
            int size=q.size();

            for(int i=0;i<size;i++) {
                Virus cur = q.poll();

                for (int dir = 0; dir < 4; dir++) {
                    int newR = cur.row + dirR[dir];
                    int newC = cur.col + dirC[dir];

                    if (newR < 0 || newR >= N || newC < 0 || newC >= N || visit[newR][newC] || map[newR][newC] != 0)
                        continue;

                    visit[newR][newC] = true;
                    map[newR][newC] = cur.num;
                    tempQ.add(new Virus(cur.num,newR,newC));
                }
            }

            S--;
            q.addAll(tempQ);
            tempQ.clear();
        }
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(map[X][Y]));
        out.close();
    }
}
