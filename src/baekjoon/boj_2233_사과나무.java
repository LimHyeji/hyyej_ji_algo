package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2233_사과나무 {
    static int n,x,y;
    static String tree;
    static int target,resX,resY;
    static int[] root,par;
    static boolean[] visit;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(in.readLine());
        tree=in.readLine();
        StringTokenizer st=new StringTokenizer(in.readLine());
        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());

        root=new int[2*n+1];//트리 만들기
        par=new int[n+1];//각 부모 체크하기
        visit=new boolean[n+1];
        stack=new Stack<>();
        resX=0;//x위치의 정점 찾기
        resY=0;//y위치의 정점 찾기

        int cnt=1;
        for(int i=0;i<tree.length();i++){
            int cur=0;
            char c=tree.charAt(i);
            if(c=='0'){
                cur=cnt++;
                stack.push(cur);
            }
            else{
                cur=stack.pop();
                if(!stack.isEmpty()) par[cur]=stack.peek();
                else par[cur]=cur;
            }
            if(i+1==x) resX=cur;
            if(i+1==y) resY=cur;
            root[i+1]=cur;
        }
        check(resX,resY);

        int res1=0,res2=0;
        for(int i=1;i<2*n+1;i++){
            if(root[i]==target){
                if(res1==0) res1=i;
                else{
                    res2=i;
                    break;
                }
            }
        }

        System.out.println(res1+" "+res2);

        in.close();
    }

    static void check(int resX,int resY){
        if(resX==resY) target=resX;
        else if(visit[resX]&&par[resX]!=resX) target=resX;
        else if(visit[resY]&&par[resY]!=resY) target=resY;
        else if(par[resX]==par[resY]) target=par[resX];
        else{
            visit[resX]=visit[resY]=true;
            check(par[resX],par[resY]);
        }
    }
}
