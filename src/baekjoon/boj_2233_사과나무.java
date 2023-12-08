package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2233_사과나무 {
    static int n,x,y;
    static String tree;
    static Stack<Integer> stack;
    static StringBuilder str;

    static HashSet<Integer> child[];
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        tree=in.readLine();
        StringTokenizer st=new StringTokenizer(in.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());

        child=new HashSet[n+1];
        for(int i=1;i<=n;i++){
            child[i]=new HashSet<>();
        }
        set=new HashSet<>();
        stack=new Stack<>();
        int cnt=0;
        for(int i=0;i<tree.length();i++){
            char c=tree.charAt(i);
            if (c == '0') {
                cnt++;
                set.add(cnt);
                stack.add(cnt);
                for(int num: set){
                    if(cnt==num) continue;
                    child[num].add(cnt);
                }
                if(i+1==x) x=cnt;
                if(i+1==y) y=cnt;
            }
            else{
                int top=stack.pop();
                set.remove(top);
                if(i+1==x) x=top;
                if(i+1==y) y=top;
            }
        }

//        for(int i=1;i<=n;i++){
//            System.out.println(i+"th");
//            for (int num:child[i]){
//                System.out.print(num+" ");
//            }
//            System.out.println();
//        }

        str=new StringBuilder();

        int par=-1;
        for(int i=n;i>0;i--){
            if(child[i].contains(x)&&child[i].contains(y)){
                par=i+1;
                break;
            }
        }
        if(par==-1) par=1;

        cnt=0;
        stack=new Stack<>();
        for(int i=0;i<tree.length();i++){
            char c=tree.charAt(i);
            if(c=='0'){
              cnt++;
              stack.push(cnt);
              if(cnt==par) str.append(i+1).append(" ");
            }
            else{
                int top=stack.pop();
                if(top==par) str.append(i+1);
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
