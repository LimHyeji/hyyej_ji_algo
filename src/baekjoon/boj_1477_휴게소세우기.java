package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1477_휴게소세우기 {
    static int n,m,len;
    static List<Integer> list;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        len=Integer.parseInt(st.nextToken());

        list=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.add(0);
        list.add(len);
        Collections.sort(list);



        out.write(String.valueOf(max));
        out.close();
        in.close();
    }

    static void search(int left,int right,int max){
        int mid=(left+right)/2;

    }
}
