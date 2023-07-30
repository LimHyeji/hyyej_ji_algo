package baekjoon;

import java.io.*;

public class boj_10974_모든순열 {
    static int n;
    static int[] num;
    static boolean[] sel;
    static StringBuilder str=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        num=new int[n];
        sel=new boolean[n+1];
        sol(0);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void sol(int cnt){
        if(cnt==n){
            for(int i=0;i<n;i++){
                str.append(num[i]).append(" ");
            }
            str.append("\n");
            return;
        }
        for(int i=1;i<n+1;i++){
            if(sel[i]) continue;
            num[cnt]=i;
            sel[i]=true;
            sol(cnt+1);
            sel[i]=false;
        }
    }
}
