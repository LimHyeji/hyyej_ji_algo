package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1669_멍멍이쓰다듬기 {
    static long x,y;
    static long res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        long dif=y-x;
        if(dif==0){
            res =0;
        }
        else {
            long n=1;
            while(n*n<=dif) n++;
            n--;

            res=2*n-1;

            dif-=n*n;
            while(dif>0){
                for(long i=n;i>=1;i--){
                    if(dif>=i){
                        res++;
                        dif-=i;
                        break;
                    }
                }
            }
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
