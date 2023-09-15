package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_6068_시간관리하기 {
    static class Work implements Comparable<Work>{
        int time, end;
        Work(int time,int end){
            this.time=time;
            this.end=end;
        }

        @Override
        public int compareTo(Work o) {
            return Integer.compare(o.end,this.end);
        }
    }
    static ArrayList<Work> works;
    static int n,res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        works=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int time=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            works.add(new Work(time,end));
        }

        Collections.sort(works);

        int nextStart=works.get(0).end-works.get(0).time;
        for(int i=1;i<n;i++){
            int start=nextStart-works.get(i).time;

            if(start>works.get(i).end-works.get(i).time){
                start=works.get(i).end-works.get(i).time;
            }

            System.out.println("START :: "+start);
            System.out.println("NEXT START :: "+nextStart);
            nextStart=start;
            res=start;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
