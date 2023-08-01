package baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_13910_개업 {
    static int n,m;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        pq=new PriorityQueue<>(Collections.reverseOrder());
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<m;i++){
            int input=Integer.parseInt(st.nextToken());
            pq.add(input);
        }

        int res=0;
        int max=0;
        while(!pq.isEmpty()){
            int cur=pq.poll();
            if(cur<=n){
                res=n/cur;
                n-=res*cur;
                max=Math.max(max,res);
            }
        }

        if(n>0){
            out.write(String.valueOf(-1));
        }
        else{
            out.write(String.valueOf(max));
        }
        out.close();
        in.close();
    }
}
