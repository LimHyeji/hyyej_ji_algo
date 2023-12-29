package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class boj_12904_A와B {
    static StringBuilder s;
    static String t;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        s=new StringBuilder(in.readLine());
        t=in.readLine();

        out.write(String.valueOf((search(s)?1:0)));
        out.close();
        in.close();
    }

    public static boolean search(StringBuilder s){
        Queue<StringBuilder> q=new ArrayDeque<>();
        q.add(s);

        while(!q.isEmpty()){
            StringBuilder cur=q.poll();

            if(cur.toString().equals(t)) return true;
            if(cur.length()>=t.length()) continue;

            StringBuilder cur1=new StringBuilder(cur);
            StringBuilder cur2 = new StringBuilder(cur);

            if(!t.contains(cur.toString())&&!t.contains(cur.reverse().toString())) continue;

            q.add(cur1.append('A'));
            q.add(cur2.reverse().append('B'));

        }

        return false;
    }
}
