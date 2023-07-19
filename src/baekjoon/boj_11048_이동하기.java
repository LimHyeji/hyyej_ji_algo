package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11048_이동하기 {
    static int n,m;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        dp=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0&&j==0)
                    continue;
                else if(i==0){
                    dp[i][j]+=dp[i][j-1];
                }
                else if(j==0){
                    dp[i][j]+=dp[i-1][j];
                }
                else{
                    dp[i][j]+=Math.max(dp[i-1][j],Math.max(dp[i][j-1],dp[i-1][j-1]));
                }
            }
        }

//        for(int [] arr:dp){
//            System.out.println(Arrays.toString(arr));
//        }
//
        out.write(String.valueOf(dp[n-1][m-1]));
        out.close();
        in.close();
    }


}
