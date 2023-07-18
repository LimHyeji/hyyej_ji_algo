package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1004_어린왕자 {
    static int t;
    static int x1,y1,x2,y2;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str=new StringBuilder();

        t=Integer.parseInt(in.readLine());

        for(int test_case=1;test_case<=t;test_case++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            x1=Integer.parseInt(st.nextToken());
            y1=Integer.parseInt(st.nextToken());
            x2=Integer.parseInt(st.nextToken());
            y2=Integer.parseInt(st.nextToken());

            int cnt=0;
            n=Integer.parseInt(in.readLine());
            for(int i=0;i<n;i++){
                st=new StringTokenizer(in.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                int r=Integer.parseInt(st.nextToken());
                if(pass(x,y,r)) cnt++;
            }

            str.append(cnt).append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }

    public static boolean pass(int x,int y,int r){
        if(cal(x1,y1,x,y)<r&&cal(x2,y2,x,y)>r) return true;
        if(cal(x1,y1,x,y)>r&&cal(x2,y2,x,y)<r) return true;
        return false;
    }

    public static double cal(int x1,int y1,int x2,int y2){
        return Math.abs(Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2)));
    }
}
