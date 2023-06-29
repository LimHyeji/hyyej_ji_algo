package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_2146_다리만들기 {
    static int n;
    static int[][] map;
    static boolean[][][] visit;
    static int name;

    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
        int name;
        Node(int row,int col,int name){
            this.row=row;
            this.col=col;
            this.name=name;
        }
    }

    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        map=new int[n][n];
        visit=new boolean[2][n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        name=0;
        list=new ArrayList<>();
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1&&!visit[0][i][j]) {
                    naming(i, j,++name);
                }
            }
        }

//        for(int [] arr:map){
//            System.out.println(Arrays.toString(arr));
//        }

//        for(Node cur:list){
//            System.out.println(cur.row+","+cur.col+","+cur.name);
//        }

        int res=Integer.MAX_VALUE;
        int size=list.size();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j||list.get(i).name==list.get(j).name){
                    continue;
                }
                res=Math.min(res,connect(i,j));
            }
        }
        System.out.println(res);
        in.close();
    }

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static void naming(int i,int j,int name){
        Queue<Node> q=new ArrayDeque<>();
        map[i][j]=name;
        visit[0][i][j]=true;
        q.add(new Node(i,j));

        while(!q.isEmpty()) {
            Node cur = q.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newR = cur.row + dirR[dir];
                int newC = cur.col + dirC[dir];
                if (newR < 0 || newR >= n || newC < 0 || newC >= n ||visit[0][newR][newC] ){
                    continue;
                }
                if(map[newR][newC] != 1){
                    if(!visit[1][cur.row][cur.col]){
                        visit[1][cur.row][cur.col]=true;
                        list.add(new Node(cur.row,cur.col,map[cur.row][cur.col]));
                    }
                    continue;
                }
                map[newR][newC] = name;
                visit[0][newR][newC] = true;
                q.add(new Node(newR, newC));
            }
        }
    }

    static int connect(int idx1,int idx2){
        return Math.abs((list.get(idx1).row-list.get(idx2).row))+Math.abs((list.get(idx1).col-list.get(idx2).col))-1;
    }
}
