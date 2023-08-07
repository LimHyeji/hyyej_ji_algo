package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1744_수묶기 {
    static int n;
    static ArrayList<Integer> list;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        list=new ArrayList<>();
        sum=0;
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            if(n==1) sum=input;
            list.add(input);
        }
        if(n>1) {
            Collections.sort(list);
            boolean[] visit=new boolean[n];
            for(int i=0;i<n-1;i++){
                if(visit[i]) continue;

                //System.out.print(list.get(i)+" ");
                if(list.get(i)<0){
                    if(list.get(i+1)<=0){
                        sum+=list.get(i)*list.get(i+1);
                        visit[i]=true;
                        visit[i+1]=true;
                    }
                    else{
                        sum+=list.get(i);
                        visit[i]=true;
                    }
                }
                else if(list.get(i)==0){
                    if(list.get(i+1)==0){
                        //더할 필요 없음
                        visit[i]=true;
                        visit[i+1]=true;
                    }
                    else{
                        //더할 필요 없음
                        visit[i]=true;
                    }
                }
                else{
                    if(list.get(i)==1){
                        sum+=list.get(i);
                        visit[i]=true;
                    }
                    else if((n-i+1)%2==1){
                        sum+=list.get(i)*list.get(i+1);
                        visit[i]=true;
                        visit[i+1]=true;
                    }
                    else{
                        sum+=list.get(i);
                        visit[i]=true;
                    }
                }
            }
            if(!visit[n-1]) sum+=list.get(n-1);
        }
        out.write(String.valueOf(sum));
        out.close();
        in.close();
    }
}