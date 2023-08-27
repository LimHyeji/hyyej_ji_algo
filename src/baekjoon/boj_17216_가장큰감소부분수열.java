package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_17216_가장큰감소부분수열 {
    static int n;
    static int[] arr,dp;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        arr=new int[n];
        dp=new int[n];

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            dp[i]=arr[i];
        }

        res=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]) dp[i]=Math.max(dp[i],dp[j]+arr[i]);
            }
            res=Math.max(res,dp[i]);
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
