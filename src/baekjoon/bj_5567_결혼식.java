package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5567_결혼식 {
    static int n,m;
    static ArrayList<Integer>[] list;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        list=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            if(a!=1){
                list[b].add(a);
            }
            list[a].add(b);

        }

        res=0;
        sol();
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static void sol(){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(1);
        boolean[] visit=new boolean[n+1];
        visit[1]=true;
        int cnt=0;
        while(cnt<2) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int next : list[cur]) {
                    if (!visit[next]) {
                        q.add(next);
                        res++;
                        visit[next] = true;
                    }
                }
            }
            cnt++;
        }
    }
}
