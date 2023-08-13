package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {
    static int n,w,l;//전체 트럭 수, 다리 길이, 다리 최대하중
    static int time;//전체 결과
    static Queue<Integer> trucks;
    static Queue<Integer> bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(in.readLine());
        trucks=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(st.nextToken());
            trucks.offer(input);
        }

        bridge=new ArrayDeque<>();
        for(int i=0;i<w;i++){
            bridge.offer(0);
        }

        time=0;
        int temp=0;
        while(!bridge.isEmpty()){
            time++;
            temp-=bridge.poll();
            if(!trucks.isEmpty()){
                if(trucks.peek()+temp<=l){
                    temp+=trucks.peek();
                    bridge.offer(trucks.poll());
                }
                else{
                    bridge.offer(0);
                }
            }
        }

        out.write(String.valueOf(time));
        out.close();
        in.close();

    }
}
