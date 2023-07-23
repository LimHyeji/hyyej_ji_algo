package baekjoon;

import java.io.*;

public class boj_15624_피보나치수7 {
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(in.readLine());
        dp=new long[n+1];
        if(n>0) {
            dp[1] = 1;
        }
        for(int i=2;i<n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
            if(dp[i]>1_000_000_007){
                dp[i]%=1_000_000_007;
            }
        }
        out.write(String.valueOf(dp[n]));
        out.close();
        in.close();
    }
}
