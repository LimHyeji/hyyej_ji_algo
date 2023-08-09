package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {
    static int n,w,l;//전체 트럭 수, 다리 길이, 다리 최대하중
    static int w2,l2;
    static int time;//전체 결과
    static Queue<Integer> trucks;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        w2=w;
        l2=l;

        st=new StringTokenizer(in.readLine());
        trucks=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            trucks.offer(input);
        }

        time=0;
        while(!trucks.isEmpty()){

            int temp=trucks.peek();
            while(!trucks.isEmpty()&&temp<l2&&w2>0){
                l2-=trucks.poll();
                w2--;
                if(!trucks.isEmpty())  temp=trucks.peek();
            }

            time+=w;

            l2=l;
            w2=w;
        }

        out.write(String.valueOf(time));
        out.close();
        in.close();

    }
}
