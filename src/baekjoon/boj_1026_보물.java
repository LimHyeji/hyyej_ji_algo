package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1026_보물 {
    static int n;
    static ArrayList<Integer> a;
    static ArrayList<Integer> b;
    static ArrayList<Integer> c;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());
        a=new ArrayList<>();
        b=new ArrayList<>();
        c=new ArrayList<>();
        StringTokenizer st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            a.add(input);
        }
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            b.add(input);
            c.add(input);
        }

        Collections.sort(a);
        Collections.sort(c);

        int res=0;
        for(int i=0;i<n;i++){
            res+=a.get(i)*c.get(n-i-1);
        }
        System.out.println(res);

    }
}
