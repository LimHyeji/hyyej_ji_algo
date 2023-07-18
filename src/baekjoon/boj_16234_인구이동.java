package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234_인구이동 {
    static int n, l, r;
    static int[][] map;
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static boolean[][] visit;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list=new ArrayList<>();
        System.out.println(sol());

    }


    static int sol() {
        int day=0;

        while (true) {
            boolean move=false;
            visit=new boolean[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(!visit[i][j]) {
                        list.clear();
                        int sum=bfs(i,j);
                        //리스트에 나를 제외한 값 존재 시
                        if(list.size()>1) {
                            move=true;
                            change(sum);
                        }
                    }
                }
            }

            if(move) day++;
            else return day;
        }
    }

    static int[] dirR= {-1,1,0,0};
    static int[] dirC= {0,0,-1,1};
    static int bfs(int row,int col) {
        int sum=0;

        Queue<Node> q=new LinkedList<>();
        q.add(new Node(row,col));
        list.add(new Node(row,col));
        visit[row][col]=true;
        sum+=map[row][col];

        while(!q.isEmpty()) {
            Node cur=q.poll();

            for(int dir=0;dir<4;dir++) {
                int newR=dirR[dir]+cur.row;
                int newC=dirC[dir]+cur.col;

                if(newR<0||newR>=n||newC<0||newC>=n||visit[newR][newC]) {
                    continue;
                }

                if(Math.abs(map[newR][newC]-map[cur.row][cur.col])>=l&&Math.abs(map[newR][newC]-map[cur.row][cur.col])<=r) {
                    q.add(new Node(newR,newC));
                    list.add(new Node(newR,newC));
                    visit[newR][newC]=true;
                    sum+=map[newR][newC];
                }
            }
        }
        return sum;
    }

    static void change(int sum) {
        sum/=list.size();
        for(Node n:list) {
            map[n.row][n.col]=sum;
        }
    }
}
