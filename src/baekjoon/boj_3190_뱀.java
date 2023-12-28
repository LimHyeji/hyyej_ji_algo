package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_3190_뱀 {
    static int n,k,l;
    static int[][] map;
    static char[] time;

    /*
    1. 몸길이 ++, 머리 이동
    2. (종료 조건) 벽이나 몸에 부딪히면 끝
    3. 이동 칸에 사과 있다면, 사과 X
    4. 이동 칸에 사과 없다면, 몸길이 --, 꼬리 X (머리가 이미 이동한 것이므로 이전의 몸길이가 변하지 않은 것과 같다)
     */

    static int[] dirR={-1,1,0,0};//상하좌우(0123)
    static int[] dirC={0,0,-1,1};

    static class Node{
        int row, col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static List<Node> list;
    static int dir,res;

    public static void main(String[] args) throws IOException {
        init();
        solution();
        print();
    }

    public static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(in.readLine());
        map=new int[n][n];

        k=Integer.parseInt(in.readLine());
        for(int i=0;i<k;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int row=Integer.parseInt(st.nextToken())-1;
            int col=Integer.parseInt(st.nextToken())-1;
            map[row][col]=1;//사과 표시
        }

        l=Integer.parseInt(in.readLine());
        time=new char[10002];
        Arrays.fill(time,'.');
        for(int i=0;i<l;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int idx=Integer.parseInt(st.nextToken())+1;
            char c=st.nextToken().charAt(0);
            time[idx]=c;
        }

        list=new ArrayList<>();
        list.add(new Node(0,0));
        map[0][0]=-1;//뱀의 위치

        dir=3;
        res=0;//종료되는 시점

        in.close();
    }

    public static void solution(){
        while(true){
            res++;

//            System.out.println("현재 길이 "+list.size()+" , 시간 "+res+" , 방향 "+dir);
            if(time[res]=='L'){
                dir=turnLeft(dir);
            }
            else if(time[res]=='D'){
                dir=turnRight(dir);
            }
//            System.out.println("회전 후 방향 "+dir);

            int newR=dirR[dir]+list.get(list.size()-1).row;
            int newC=dirC[dir]+list.get(list.size()-1).col;
//            System.out.println("이동 후 위치 "+newR+" "+newC);

            if(newR<0||newR>=n||newC<0||newC>=n||map[newR][newC]==-1) break;

            if(map[newR][newC]!=1){
//                System.out.println("삭제할 꼬리 "+list.get(0).row+" "+list.get(0).col);
                map[list.get(0).row][list.get(0).col]=0;
                list.remove(0);
//                System.out.println("삭제 후 길이 "+list.size());
            }

            list.add(new Node(newR,newC));
            map[newR][newC]=-1;
//            printMap();
//            System.out.println();
        }
    }

    /*
    'L' : 왼쪽 회전
    상(0)->좌(2)
    하(1)->우(3)
    좌(2)->하(1)
    우(3)->상(0)
     */
    public static int turnLeft(int curDir){
        switch(curDir){
            case 0: return 2;
            case 1: return 3;
            case 2: return 1;
            default: return 0;
        }
    }

    /*
    'D' : 오른쪽 회전
    상(0)->우(3)
    하(1)->좌(2)
    좌(2)->상(0)
    우(3)->하(1)
     */
    public static int turnRight(int curDir){
        switch(curDir){
            case 0: return 3;
            case 1: return 2;
            case 2: return 0;
            default: return 1;
        }
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(res));
        out.close();
    }

    static void printMap(){
        for(int[] arr:map){
            System.out.println(Arrays.toString(arr));
        }
    }

}
