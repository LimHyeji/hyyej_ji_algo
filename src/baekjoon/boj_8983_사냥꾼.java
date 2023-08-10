package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_8983_사냥꾼 {
    static int m,n,l;
    static ArrayList<Integer> start;
    static ArrayList<Integer> end;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        start=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<m;i++){
            start.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(start);

        end=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(b>l) continue;

            end.add(a+b);
        }
        Collections.sort(end);


    }

    static void search(int start,int end){

    }
}
