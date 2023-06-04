package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
import java.io.*
import java.util.*
 */

public class Main {
    /*
    . 빈칸
    * 물
    X 돌
    D 비버의 굴
    S 고슴도치 위치
     */
    static int r,c;
    static class Node{
        int row,col;

        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static char[][] map;
    static Queue<Node> water;
    static Queue<Node> q;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        map=new char[r][c];
        water=new LinkedList<>();
        q=new LinkedList<>();

        for(int i=0;i<r;i++){
            String input=in.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=input.charAt(j);
                if(map[i][j]=='*'){
                    water.add(new Node(i,j));
                }
                if(map[i][j]=='S'){
                    q.add(new Node(i,j));
                }
            }
        }

        out.write(solution());
        out.close();
        in.close();

    }

    static void water(){
        int size=water.size();
        for(int i=0;i<size;i++){
            Node cur=water.poll();

            for(int dir=0;dir<4;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];

                /*
                범위 체크를 메소드화하기
                if문 최소화하기
                 */
                if(newR<0||newR>=r||newC<0||newC>=c||map[newR][newC]=='X'||map[newR][newC]=='D'||map[newR][newC]=='*'){
                    continue;
                }

                    map[newR][newC]='*';
                    water.add(new Node(newR,newC));

            }
        }
    }

    static String solution() {
        int cnt=0;
        while(!q.isEmpty()){
            water();
//            System.out.println(cnt+"번째");
//            print();

            /*
            최단비용 구하기 위해 depth를 한단계씩 넓히기
             */
            int size=q.size();
            for(int i=0;i<size;i++) {
                Node cur=q.poll();
                if(map[cur.row][cur.col]=='S'){
                    map[cur.row][cur.col]='.';
                }

                    for (int dir = 0; dir < 4; dir++) {
                        int newR = cur.row + dirR[dir];
                        int newC = cur.col + dirC[dir];

                        if(newR<0||newR>=r||newC<0||newC>=c||map[newR][newC]=='X'||map[newR][newC]=='*'){
                            continue;
                        }

                            if (map[newR][newC] == 'D') {
                                return Integer.toString(cnt + 1);
                            }

                            if (map[newR][newC] == '.') {
                                map[newR][newC] = 'S';
                                q.add(new Node(newR, newC));
                            }

                    }
                }
                cnt++;
        }
        return "KAKTUS";
    }

    static void print(){
        for(char[] c:map){
            System.out.println(Arrays.toString(c));
        }
    }
}
