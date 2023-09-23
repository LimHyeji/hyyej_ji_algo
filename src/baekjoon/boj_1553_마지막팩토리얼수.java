package baekjoon;

import java.util.Scanner;

public class boj_1553_마지막팩토리얼수 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        int[] dp=new int[20001];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=6;
        dp[4]=4;

        for(int i=5;i<=n;i++){
            if(i%5==0){
                int q=i/5;
                dp[i]=((int)Math.pow(2,q%4)*dp[q])%10;
            }
            else{
                int before=(i/5)*5;
                int total=1;
                for(int j=i;j>before;j--){
                    total*=(j%10);
                }
                total*=dp[before];
                dp[i]=total%10;
            }
        }

        System.out.println(dp[n]);
    }
}
