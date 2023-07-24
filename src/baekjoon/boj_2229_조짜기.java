package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2229_조짜기 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        arr=new int[n];

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        /*
        EX) 2 5 7 1 3 4 8 6 9 3
         */
        dp=new int[n];
        //0 0 0 0 0 0 0 0 0 0
        dp[1]=Math.abs(arr[1]-arr[0]);
        //0 3 0 0 0 0 0 0 0 0
        for(int i=2;i<n;i++){
            int max=arr[i];
            int min=arr[i];
            for(int j=i;j>0;j--){
                max=Math.max(max,arr[j]);
                min=Math.min(min,arr[j]);
                if(dp[j-1]+(max-min)>dp[i]){
                    dp[i]=dp[j-1]+(max-min);
                }
            }
        }
        //System.out.println(Arrays.toString(dp));

        out.write(String.valueOf(dp[n-1]));
        out.close();
        in.close();
    }
}
