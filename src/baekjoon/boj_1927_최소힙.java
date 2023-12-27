package baekjoon;

import java.io.*;
import java.util.PriorityQueue;

public class boj_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        StringBuilder str=new StringBuilder();

        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            if(input==0){
                if(pq.isEmpty()) str.append(0);
                else str.append(pq.poll());
                str.append("\n");
            }
            else{
                pq.add(input);
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
