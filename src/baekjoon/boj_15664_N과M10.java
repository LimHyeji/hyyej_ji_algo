package baekjoon;

import java.io.*;
import java.util.*;

public class boj_15664_N과M10 {
    static int n,m;
    static int[] num;
    static StringBuilder str;
    static boolean[] sel;
    static int[] arr;
    static List<String> result;

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
        result=new ArrayList<>();
        com(0,0);
        str=new StringBuilder();
        for(String string:result){
            str.append(string).append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
    static void com(int start,int cnt){
        if(cnt==m){
            str=new StringBuilder();
            for(int i=0;i<m;i++){
                str.append(arr[i]).append(" ");
            }
            for(String string:result){
                if(string.equals(str.toString())){
                    return;
                }
            }
            result.add(str.toString());
            return;
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
