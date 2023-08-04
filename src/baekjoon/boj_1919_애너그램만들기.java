package baekjoon;

import java.io.*;

public class boj_1919_애너그램만들기 {
    static int [] a;
    static int [] b;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        a=new int[26];
        b=new int[26];

        String input=in.readLine();
        for(int i=0;i<input.length();i++){
            int c=input.charAt(i)-'a';
            a[c]++;
        }

        input=in.readLine();
        for(int i=0;i<input.length();i++){
            int c=input.charAt(i)-'a';
            b[c]++;
        }

        int res=0;
        for(int i=0;i<26;i++){
            res+=Math.abs(a[i]-b[i]);
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

}
