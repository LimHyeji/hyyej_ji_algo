package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_22920_서로소평균 {
    static int n;
    static int [] arr;
    static int x;
    static double sum,cnt;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(in.readLine());
        arr=new int[n];

        StringTokenizer st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        x=Integer.parseInt(in.readLine());
        list=new ArrayList<>();
        for(int i=2;i<=x;i++){
            if(x%i==0){
                list.add(i);
            }
        }

        sum=0;cnt=0;
        for(int i=0;i<n;i++){
            if(!check(arr[i])){
                sum+=arr[i];
                cnt++;
            }
        }

        out.write(String.valueOf((sum/cnt)));
        out.close();
        in.close();
    }

    static boolean check(int num){
        for(int l:list){
            if(num%l==0) return true;
        }
        return false;
    }
}
