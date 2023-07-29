package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2228_구간나누기 {
    static int n,m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        dp=new int[n][n];

        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            for(int j=0;j<i;j++){
                dp[j][i]+=input;
            }
            for(int j=i;j<n;j++){
                dp[i][j]=input;
            }
        }

        for(int start=0;start<n;start++){
            for(int end=0;end<n;end++){

            }
        }
    }
}
