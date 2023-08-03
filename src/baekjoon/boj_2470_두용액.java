package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2470_두용액 {
    static int n;
    static ArrayList<Long> list;
    static long a,b;
    static long sum;
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(in.readLine());
        list=new ArrayList<>();
        a=-1;
        b=-1;
        sum=2_000_000_000;
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            list.add(Long.parseLong(st.nextToken()));
        }
        Collections.sort(list);

        int left=0;
        int right=n-1;
//        for(long e: list){
//            System.out.print(e+" ");
//        }
//        System.out.println();

        sol(left,right);
        str.append(a).append(" ").append(b);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void sol(int left,int right){
        if(left>=right) return;
        long sel_current=Math.abs(list.get(left)+list.get(right));
        if(sum>sel_current){
            a=list.get(left);
            b=list.get(right);
            sum=sel_current;
        }
        long sel_left=Math.abs(list.get(left+1)+list.get(right));
        long sel_right=Math.abs(list.get(left)+list.get(right-1));

//        System.out.println("LEFT: "+list.get(left)+", RIGHT: "+list.get(right));
//        System.out.println("SEL CURRENT: "+sel_current);
//        System.out.println("SEL LEFT: "+sel_left);
//        System.out.println("SEL RIGHT: "+sel_right);

        if(sel_left<sel_right){
//            System.out.println("왼쪽 1 증가");
            sol(left+1,right);
        }
        else if(sel_left>sel_right){
//            System.out.println("오른쪽 1 감소");
            sol(left,right-1);
        }
        else{
                sol(left + 1, right - 1);
            }
    }
}
