package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11399_ATM {
    static int n,res;
    static List<Integer> p;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        p=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++) {
            p.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(p);

        res=0;
        for(int i=0;i<n;i++){
            res+=p.get(i)*(p.size()-i);
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
