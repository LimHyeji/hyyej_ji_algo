package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11568_민균이의계략 {
    static int n;
    static int[] arr;
    static int[] dp;

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
        }

        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }

        int res=0;
        for(int i=0;i<n;i++){
            res=Math.max(res,dp[i]);
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
