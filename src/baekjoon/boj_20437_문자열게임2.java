package baekjoon;

import java.io.*;
import java.util.ArrayList;

public class boj_20437_문자열게임2 {
    static int t;
    static ArrayList<Integer>[] count;
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        t=Integer.parseInt(in.readLine());
        for(int test_case=1;test_case<t;test_case++){
            int min=Integer.MAX_VALUE,max=-1;
            count=new ArrayList[26];
            for(int i=0;i<26;i++){
                count[i]=new ArrayList<>();
            }

            String w=in.readLine();
            int k=Integer.parseInt(in.readLine());

            for(int i=0;i<w.length();i++){
                char c=w.charAt(i);
                count[c-'a'].add(i);
            }

            for(int i=0;i<26;i++){
                if(count[i].size()==k){
                    int last=count[i].size()-1;
                    //min=max=count[i].get(last)-count[i].get(0);
                }
                else if(count[i].size()>k){
                    int size=count[i].size();
                    size-=k;
                    for(int j=0;j<size;j++){
                       // min=
                    }
                }
            }

            if(max!=-1)
                str.append(min).append(" ").append(max).append("\n");
            else
                str.append(-1).append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
}
