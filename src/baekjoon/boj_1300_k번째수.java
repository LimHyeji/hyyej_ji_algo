package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class boj_1300_k번째수 {
    static int n,k;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        k=Integer.parseInt(in.readLine());

        arr=new int[n*n+1];
        arr[1]=1;
        arr[n*n]=n;
        int idx=1;
        int temp=n+2;
        int left=1;
        int right=n*n;
        for(int i=1;i<=n-2;i++){
            idx++;
            arr[1+temp*i]=idx;//idx의 제곱이 저장되어야 함. idx 기록
//            System.out.println("LEFT? "+(1+temp*(i-1)));
//            System.out.println("RIGHT? "+(1+temp*i));
            if(k>=1+temp*(i-1)&&k<=1+temp*i){
                left=1+temp*(i-1);
                right=1+temp*i;
            }
        }
        if(left==1&&right==n*n){
            left=1+temp*(n-2);
        }

//        System.out.println(Arrays.toString(arr));
        System.out.println("LEFT: "+left);
        System.out.println("RIGHT: "+right);
        System.out.println(arr[left]);
        System.out.println(arr[right]);
//        sol(left,right);
        out.write(String.valueOf(sol(left,right)));
        out.close();
        in.close();
    }

    static int sol(int left,int right){

    }
}
