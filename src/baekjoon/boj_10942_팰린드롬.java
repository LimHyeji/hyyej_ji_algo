package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10942_팰린드롬 {
    static int n,m;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(in.readLine());
        arr=new int[n];
        dp=new boolean[n][n];

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int center=1;center<n-1;center++){
            for(int len=1;len<n;len++){
                if(center-len<0||center+len>=n){
                    break;
                }
                int left=center-len;
                int right=center+len;
                if(arr[left]!=arr[right]){
                    break;
                }
                else{
                    dp[left][right]=true;
                }
            }
        }
        for(int left_center=0;left_center<n-1;left_center++){
            int right_center=left_center+1;
            if(arr[left_center]!=arr[right_center]){
                continue;
            }
            dp[left_center][right_center]=true;
            for(int len=1;len<n;len++){
                if(left_center-len<0||right_center+len>=n){
                    break;
                }
                int left=left_center-len;
                int right=right_center+len;
                if(arr[left]!=arr[right]){
                    break;
                }
                else{
                    dp[left][right]=true;
                }
            }
        }

//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                if(dp[i][j]){
//                    System.out.println("left : "+i+", right : "+j);
//                }
//            }
//        }

        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int s=Integer.parseInt(st.nextToken())-1;
            int e=Integer.parseInt(st.nextToken())-1;
            if(s==e||dp[s][e]){
                str.append(1).append("\n");
            }
            else{
                str.append(0).append("\n");
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
