package baekjoon;

import java.io.*;

public class boj_12871_무한문자열 {
    static String s,t;
    static StringBuilder str1=new StringBuilder();
    static StringBuilder str2=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        s=in.readLine();
        t=in.readLine();

        for(int i=0;i<50;i++){
            str1.append(s);
            for(int j=0;j<50;j++){
                str2.append(t);
                if(str1.toString().equals(str2.toString())){
                    out.write(String.valueOf(1));
                    out.close();
                    in.close();
                    System.exit(0);
                }
            }
            str2=new StringBuilder();
        }

        out.write(String.valueOf(0));
        out.close();
        in.close();
    }
}
