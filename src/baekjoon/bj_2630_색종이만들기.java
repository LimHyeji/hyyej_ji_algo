package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_2630_색종이만들기 {
    static int n;
    static int[][] map;
    static int white,blue;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(in.readLine());
        map=new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            for (int j=0;j<n;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        white=0;
        blue=0;

        sol(0,0,n);

        System.out.println(white+"\n"+blue);
    }

    static void sol(int row,int col,int size){
        if(!check(row,col,size,map[row][col])){
            sol(row,col,size/2);
            sol(row+size/2,col,size/2);
            sol(row,col+size/2,size/2);
            sol(row+size/2,col+size/2,size/2);
        }
        else{
            if(map[row][col]==1){
                blue++;
            }
            else{
                white++;
            }
        }
    }

    static boolean check(int row,int col,int size,int color){
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                if(map[i][j]!=color){
                    return false;
                }
            }
        }
        return true;
    }
}
