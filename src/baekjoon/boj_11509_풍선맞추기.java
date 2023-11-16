package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11509_풍선맞추기 {
    static int n;
    static int[] h;
    static int res;

    public static void main(String[] args) throws IOException {
        init();

        print();
    }

    public static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());

        h=new int[1_000_002];
        StringTokenizer st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(st.nextToken());
            if(h[num+1]>0) h[num+1]--;
            h[num]++;
        }

        in.close();
        res=0;
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<1_000_002;i++){
            if(h[i]>0) res+=h[i];
        }
        out.write(String.valueOf(res));
        out.close();
    }
}
