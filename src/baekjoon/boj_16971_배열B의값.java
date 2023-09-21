package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16971_배열B의값 {
    static int n,m;
    static int[][] arr;
    static int max;


    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        max=Integer.MIN_VALUE;

        int temp=0;

        for(int i=0;i<n;i++){
            if(i==0||i==n-1) temp+=getRowSum(arr[i],false);
            else temp+=getRowSum(arr[i],true);
        }




        out.write(String.valueOf(max));
        out.close();
        in.close();
    }

    static int getRowSum(int[] arr,boolean mid){
        int sum=0;
        if(mid){
            for(int i=0;i<m;i++){
                if(i==0||i==m-1) sum+=2*arr[i];
                else sum+=4*arr[i];
            }
        }
        else{
            for(int i=0;i<m;i++){
                if(i==0||i==m-1) sum+=arr[i];
                else sum+=2*arr[i];
            }
        }
        return sum;
    }

    static int getColSum(int[][] arr,int idx,boolean mid){
        int sum=0;
        if(mid){
            for(int i=0;i<n;i++){
                if(i==0||i==n-1) sum+=2*arr[i][idx];
                else sum+=4*arr[i][idx];
            }
        }
        else{
            for(int i=0;i<n;i++){
                if(i==0||i==n-1) sum+=arr[i][idx];
                else sum+=2*arr[i][idx];
            }
        }
        return sum;
    }
}
