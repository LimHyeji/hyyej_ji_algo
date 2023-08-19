package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_22920_서로소평균 {
    static int n;
    static int [] arr;
    static int x;
    static int sum,cnt;

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

        sum=0;cnt=0;
        for(int i=0;i<n;i++){
            if(check(arr[i])){
                sum+=arr[i];
                cnt++;
            }
        }

        out.write(String.valueOf(sum/cnt));
        out.close();
        in.close();
    }

    static boolean check(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0&&x%i==0)
                return true;
        }
        return false;
    }
}
