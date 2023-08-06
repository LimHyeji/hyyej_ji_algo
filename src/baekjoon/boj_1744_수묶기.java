package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1744_수묶기 {
    static int n;
    static ArrayList<Integer> arr;
    static int sum;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        arr=new ArrayList<>();

        sum=0;
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            arr.add(input);
            sum+=input;
        }
        if(n==1){
            res=arr.get(0);
        }
        else{
            Collections.sort(arr);
            res=0;
            sol(n-2,n-1,sum);
            sol2(0,1,sum);
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static void sol(int left,int right,int temp){
        int product=arr.get(left)*arr.get(right);
        if(temp-arr.get(left)-arr.get(right)+product>temp){
            if(left-2<0) {
                res=Math.max(res,temp-arr.get(left)-arr.get(right)+product);
                return;
            }
             else{
                 sol(left - 2, right - 2, temp - arr.get(left) - arr.get(right) + product);
            }
        }
        else{
            if(left-1<0) {
                res=Math.max(res,temp);
                return;
            }
             else{
                 sol(left - 1, right - 1, temp);
            }
        }
    }

    static void sol2(int left,int right,int temp){
        int product=arr.get(left)*arr.get(right);
        if(temp-arr.get(left)-arr.get(right)+product>temp){
            if(right+2>=n){
                res=Math.max(res,temp-arr.get(left)-arr.get(right)+product);
                return;
            }
            else{
                sol(left+2,right+2,temp-arr.get(left)-arr.get(right)+product);
            }
        }
        else{
            if(right+1>=n){
                res=Math.max(res,temp);
                return;
            }
            else{
                sol(left+1,right+1,temp);
            }
        }
    }
}
