package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15664_N과M {
    static int n,m;
    static int[] num;
    static StringBuilder str=new StringBuilder();
    static boolean[] sel;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        num=new int[n];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            num[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        sel=new boolean[n];
        arr=new int[m];
        com(0,0);
        out.write(str.toString());
        out.close();
        in.close();
    }
    static void com(int start,int cnt){
        if(cnt==m){
            for(int i=0;i<m;i++){
                str.append(arr[i]).append(" ");
            }
            str.append("\n");
        }

        for(int i=start;i<n;i++){
            if(sel[i]) continue;

            sel[i]=true;
            arr[cnt]=num[i];
            com(i+1,cnt+1);
            sel[i]=false;
        }
    }


}
