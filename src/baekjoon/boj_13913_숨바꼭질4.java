package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13913_숨바꼭질4 {
    static int n,k;
    static class Node{
        int pos,cost;
        int [] path;
        Node(int pos,int cost, int[] path){
            this.pos=pos;
            this.cost=cost;
            this.path=path;
        }
    }
    static boolean[] visit;
    static int[] path;
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        visit=new boolean[100_001];
        path=new int[100_001];

        visit[n]=true;
        path[0]=n;
        sol(n,0);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void sol(int n, int cnt){
        if(cnt>100_000) return;
        if(n==k){
            str.append(cnt).append("\n");
            for(int i=0;i<cnt;i++){
                str.append(path[i]).append(" ");
            }

            return;
        }

        if(n-1>0&&!visit[n-1]){
            path[cnt+1]=n-1;
            visit[n-1]=true;
            sol(n-1,cnt+1);
            visit[n-1]=false;
            path[cnt+1]=0;
        }

        if(n+1<100_001&&!visit[n+1]){
            path[cnt+1]=n+1;
            visit[n+1]=true;
            sol(n+1,cnt+1);
            visit[n+1]=false;
            path[cnt+1]=0;
        }

        if(n*2<100_001&&!visit[n*2]){
            path[cnt+1]=n*2;
            visit[n*2]=true;
            sol(n*2,cnt+1);
            visit[n*2]=false;
            path[cnt+1]=0;
        }
    }
}
