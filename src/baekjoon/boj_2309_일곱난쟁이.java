package baekjoon;

import java.io.*;
import java.util.Arrays;

public class boj_2309_일곱난쟁이 {

    static int sum;
    static int[] arr,res,num;
    static boolean[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        res=new int[7];

        arr=new int[9];
        num=new int[2];
        sel=new boolean[9];
        sum=0;
        for(int i=0;i<9;i++){
            arr[i]=Integer.parseInt(in.readLine());
            sum+=arr[i];
        }

        sol(0,0);

        Arrays.sort(res);
        for(int i=0;i<7;i++){
            System.out.println(res[i]);
        }

        in.close();
    }

    public static void sol(int start,int cnt){
        if(cnt==2){
            if(sum-arr[num[0]]-arr[num[1]]==100){
                int idx=0;
                for(int i=0;i<9;i++){
                    if(i==num[0]||i==num[1]) continue;
                    res[idx++]=arr[i];
                }
            }
            return;
        }

        for(int i=start;i<9;i++){
            if(sel[i]) continue;

            num[cnt]=i;

            sel[i]=true;
            sol(i+1,cnt+1);
            sel[i]=false;
        }
    }
}
