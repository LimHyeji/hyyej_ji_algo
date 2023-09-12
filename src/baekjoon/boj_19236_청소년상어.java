package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_19236_청소년상어 {
    static int[] dirR={-1,0,1,1,1,0,-1,-1};
    static int[] dirC={-1,-1,-1,0,1,1,1,0};
    static int[][] map;
    static class Fish{
        int num, pos;
        Fish(int num,int pos){
            this.num=num;
            this.pos=pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        map=new int[4][4];
        for(int i=0;i<4;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<4;j++){

            }
        }

    }

}
