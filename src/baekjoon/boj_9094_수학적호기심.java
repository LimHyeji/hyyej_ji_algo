package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_9094_수학적호기심 {
    static int t,n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        StringBuilder str=new StringBuilder();

        t=Integer.parseInt(in.readLine());
        for(int test_case=1;test_case<=t;test_case++){
            st=new StringTokenizer(in.readLine());
            n=Integer.parseInt(st.nextToken());
            m=Integer.parseInt(st.nextToken());

            int result=0;

            for(int b=1;b<n;b++){
                for(int a=1;a<b;a++){
                    int temp=a*a+b*b+m;
                    if(temp%(a*b)==0)result++;
                }
            }

            str.append(result).append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
}
