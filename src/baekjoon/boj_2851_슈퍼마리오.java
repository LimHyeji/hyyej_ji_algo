package baekjoon;

import java.io.BufferedReader;
import java.util.Scanner;

public class boj_2851_슈퍼마리오 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int[] arr=new int[11];
        int[] sum=new int[11];
        for(int i=1;i<=10;i++){
            arr[i]=sc.nextInt();
            sum[i]=arr[i]+sum[i-1];
        }

        int num=0;
        int dif=Integer.MAX_VALUE;
        for(int i=1;i<=10;i++){
            int temp=Math.abs(100-(sum[i]));
            if(temp<dif){
                dif=temp;
                num=sum[i];
            }
            else if(temp==dif){
                num=Math.max(num,sum[i]);
            }
        }
        System.out.println(num);
    }
}
