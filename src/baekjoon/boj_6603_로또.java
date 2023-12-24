package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_6603_로또 {
    static int n;
    static int[] arr,num;
    static boolean[] sel;
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer st=new StringTokenizer(in.readLine());

            n=Integer.parseInt(st.nextToken());
            if(n==0) break;

            arr=new int[n];
            num=new int[6];
            sel=new boolean[n];

            for(int i=0;i<n;i++){
                arr[i]=Integer.parseInt(st.nextToken());
            }

            sol(0,0);
            str.append("\n");
        }

        out.write(str.toString());
        out.close();
        in.close();
    }

    public static void sol(int cnt,int start){
        if(cnt==6){
            for(int i=0;i<6;i++){
                str.append(num[i]).append(" ");
            }
            str.append("\n");
            return;
        }

        for(int i=start;i<n;i++){
            if(sel[i]) continue;

            num[cnt]=arr[i];
            sel[i]=true;
            sol(cnt+1,i+1);
            sel[i]=false;
        }
    }
}
