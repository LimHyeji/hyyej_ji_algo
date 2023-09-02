package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_13910_개업 {
    static int n,m;
    static int[] woks;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        woks=new int[10001];
        dp=new int[n+1];
        Arrays.fill(dp,10001);
        woks[0]=1;
        dp[0]=0;

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<m;i++){
            woks[Integer.parseInt(st.nextToken())]++;
        }

        for(int i=1;i<n+1;i++){
            for(int j=0;j<i/2+1;j++){
                if(j==i-j&&woks[j]>=2){
                    dp[i]=1;
                }
                else if(j!=i-j&&woks[j]>0&&woks[i-j]>0){
                    dp[i]=1;
                }
                else if(dp[j]!=10001&&dp[i-j]!=10001){
                    dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
                }
            }
        }
        out.write(String.valueOf(dp[n]>=10001?-1:dp[n]));
        out.close();
        in.close();
    }
}
