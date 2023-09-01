package baekjoon;

import java.io.*;
import java.util.*;

public class boj_21939_문제추천시스템버전1 {
    static int n,m;
    static class Problem implements Comparable<Problem>{
        int num,level;
        Problem(int num,int level){
            this.num=num;
            this.level=level;
        }

        @Override
        public int compareTo(Problem o) {
            if(this.level<o.level){
                return 1;
            }
            else if(this.level==o.level){
                return Integer.compare(o.num,this.num);
            }
            else{
                return -1;
            }
        }
    }
    static TreeSet<Problem> problems;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(in.readLine());
        problems=new TreeSet<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int p=Integer.parseInt(st.nextToken());
            int l=Integer.parseInt(st.nextToken());
            problems.add(new Problem(p,l));
        }

        problems.

        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            String cmd=st.nextToken();
            if(cmd.equals("add")){
                int p=Integer.parseInt(st.nextToken());
                int l=Integer.parseInt(st.nextToken());

                problems.put(p,new Problem(p,l));

            }
            else if(cmd.equals("recommend")){
                int x=Integer.parseInt(st.nextToken());
                if(x==1){
                    str.append(problems.firstEntry().getValue().num).append("\n");
                }
                else if(x==-1){
                    str.append(problems.lastEntry().getValue().num).append("\n");
                }
            }
            else if(cmd.equals("solved")){
                int p=Integer.parseInt(st.nextToken());
                problems.remove(p);
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
