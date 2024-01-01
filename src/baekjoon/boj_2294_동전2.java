package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2294_동전2 {
    static int n,k;
    static int[] dp,coin;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        dp=new int[100001];
        coin=new int[n];
        Arrays.fill(dp,100001);
        dp[0]=0;
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            dp[input]=1;
            coin[i]=input;
        }

        for(int i=0;i<n;i++){
            for(int j=coin[i];j<=k;j++){
                dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
            }
        }

        out.write(dp[k]==100001?String.valueOf(-1):String.valueOf(dp[k]));
        out.close();
        in.close();
    }
}
