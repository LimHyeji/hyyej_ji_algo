package baekjoon;

import java.io.*;
import java.util.ArrayList;

public class boj_12933_오리 {
    static char[] input;
    static char[] c={'u','a','c','k'};
    static class Node implements Comparable<Node>{
        int start,end;
        Node(int start){
            this.start=start;
            this.end=start;
        }

        void setEnd(int end){
            this.end=end;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.end,o.end);
        }
    }
    static ArrayList<Node> list;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        input=in.readLine().toCharArray();

        if(input[0]!='q'||input.length%5!=0){
            out.write(String.valueOf(-1));
            out.close();
            in.close();
            return;
        }

        list=new ArrayList<>();
        for(int i=0;i<input.length;i++){
            if('q'==input[i]){
                input[i]='X';
                Node cur=new Node(i);
                int idx=0;
                for(int j=i+1;j<input.length;j++){
                    if(c[idx]==input[j]){
                        input[j]='X';
                        idx++;

                        if(idx==4){
                            cur.setEnd(j);
                            break;
                        }
                    }
                }
                list.add(cur);
            }
        }

        for(Node cur:list){
            if(cur.start==cur.end){
                out.write(String.valueOf(-1));
                out.close();
                in.close();
                return;
            }
        }
        for(int i=0;i<input.length;i++){
            if(input[i]!='X'){
                out.write(String.valueOf(-1));
                out.close();
                in.close();
                return;
            }
        }

        res=list.size();
        boolean[] visit=new boolean[list.size()];
        for(int i=0;i<list.size();i++){
            visit[i]=true;
            for(int j=i+1;j<list.size();j++){
                if(list.get(i).end<list.get(j).start&&!visit[j]){
                    res--;
                    visit[j]=true;
                    break;
                }
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
