package baekjoon;

import java.io.*;
import java.util.ArrayList;

public class boj_12933_오리 {
    static char[] input;
    static char[] c={'u','a','c','k'};
    static class Node{
        int start,end;
        Node(int start){
            this.start=start;
            this.end=start;
        }

        void reset(int start){
            this.start=start;
            this.end=start;
        }

        void setEnd(int end){
            this.end=end;
        }
    }

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

        int idx=0;
        ArrayList<Node> list=new ArrayList<>();
        for(int i=0;i<input.length;i++){
            if(input[i]=='q'){
                boolean reuse=false;
                int pos=-1;
                for(int j=0;j<list.size();j++){
                    if(list.get(j).start!=list.get(j).end&&list.get(j).start<i&&list.get(j).end<i) {
                        reuse=true;
                        list.get(j).reset(j);
                        pos=j;
                        break;
                    }
                }

                input[i]='X';
                if(!reuse){
                    list.add(new Node(i));
                    pos=list.size()-1;
                }
                for(int j=i+1;j<input.length;j++){
                    if(input[j]==c[idx]){
                        input[j]='X';
                        idx++;

                        if(idx==4){
                            if(reuse) {
                                list.get(pos).setEnd(j);
                            }
                            else{
                                list.get(pos).setEnd(j);
                            }
                            idx=0;
                        }
                    }
                }
            }
        }



        out.write(String.valueOf(list.size()));
        out.close();
        in.close();
    }
}
