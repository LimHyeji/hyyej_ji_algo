package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1085_직사각형에서탈출 {
    static int x,y,w,h;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        h=Integer.parseInt(st.nextToken());
        int res=Math.min(Math.abs(x-w),Math.min(Math.abs(y-h),Math.min(x,y)));
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
