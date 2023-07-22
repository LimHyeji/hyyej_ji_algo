package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1695_팰린드롬만들기 {
    static int n;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        arr=new int[n];
        dp=new int[n][n];
        for(int[] list:dp){
            Arrays.fill(list,Integer.MAX_VALUE);
        }

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        out.write(String.valueOf(solution(0,n-1)));
        out.close();
        in.close();
    }

    static int solution(int left,int right){
        if(left>=right){
            return 0;
        }
        if(dp[left][right]!=Integer.MAX_VALUE)
            return dp[left][right];

        if(arr[left]==arr[right]){
            dp[left][right]=solution(left+1,right-1);
        }else{
            dp[left][right]=Math.min(solution(left+1,right)+1,solution(left,right-1)+1);
        }
        return dp[left][right];
    }
}

