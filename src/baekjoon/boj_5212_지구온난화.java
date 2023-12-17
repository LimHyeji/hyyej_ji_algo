package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_5212_지구온난화 {
    static int r,c;
    static char[][] map;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static List<Node> list;
    static StringBuilder str;

    public static void main(String[] args) throws IOException {

        init();

        check();
        convert();
        calculateSize();

        print();

    }

    static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());
        map=new char[r][c];
        for(int i=0;i<r;i++){
            String input=in.readLine();
            for(int j=0;j<c;j++){
                map[i][j]=input.charAt(j);
            }
        }
        list=new ArrayList<>();
        str=new StringBuilder();
    }

    static void check(){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]=='X'){
                    check(i,j);
                }
            }
        }
    }

    static void check(int row,int col){
        int cnt=0;
        for(int dir=0;dir<4;dir++){
            int newR=dirR[dir]+row;
            int newC=dirC[dir]+col;
            if(newR<0||newR>=r||newC<0||newC>=c||map[newR][newC]=='.')
                cnt++;
        }

        if(cnt>=3){
            list.add(new Node(row,col));
        }
    }

    static void convert(){
        for(Node cur:list){
            map[cur.row][cur.col]='.';
        }
    }

    static void calculateSize(){
        int minRow=Integer.MAX_VALUE;
        int maxRow=0;
        int minCol=Integer.MAX_VALUE;
        int maxCol=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j]=='X'){
                    minRow=Math.min(i,minRow);
                    maxRow=Math.max(i,maxRow);
                    minCol=Math.min(j,minCol);
                    maxCol=Math.max(j,maxCol);
                }
            }
        }

        appendResult(minRow,maxRow,minCol,maxCol);

    }

    static void appendResult(int minRow,int maxRow,int minCol,int maxCol){
        for(int i=minRow;i<=maxRow;i++){
            for(int j=minCol;j<=maxCol;j++){
                str.append(map[i][j]);
            }
            str.append('\n');
        }
    }

    static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(str.toString());
        out.close();
    }

}
