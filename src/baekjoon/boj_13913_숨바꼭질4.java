package baekjoon;


import java.io.*;
import java.util.*;

public class boj_13913_숨바꼭질4 {
    static int n,k;
    static class Node{
        int cur;
        int cnt;

        Node(int cur,int cnt){
            this.cur=cur;
            this.cnt=cnt;
        }
    }
    static ArrayList<Integer>[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        Queue<Node> q=new ArrayDeque<>();
        boolean[] visit=new boolean[100_001];

        path=new ArrayList[100_001];
        for(int i=0;i<100_001;i++){
            path[i]=new ArrayList<>();
        }

        q.add(new Node(n,0));
        visit[n]=true;
        path[n].add(n);

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.cur==k){
                str.append(cur.cnt).append("\n");
                for(int e:path[k]){
                    str.append(e).append(" ");
                }
                break;
            }

            if(cur.cur-1>=0&&!visit[cur.cur-1]){
                q.add(new Node(cur.cur-1,cur.cnt+1));
                visit[cur.cur-1]=true;
                path[cur.cur-1].addAll(path[cur.cur]);
                path[cur.cur-1].add(cur.cur-1);
            }

            if(cur.cur+1<100_001&&!visit[cur.cur+1]){
                q.add(new Node(cur.cur+1,cur.cnt+1));
                visit[cur.cur+1]=true;
                path[cur.cur+1].addAll(path[cur.cur]);
                path[cur.cur+1].add(cur.cur+1);
            }

            if(cur.cur*2<100_001&&!visit[cur.cur*2]){
                q.add(new Node(cur.cur*2,cur.cnt+1));
                visit[cur.cur*2]=true;
                path[cur.cur*2].addAll(path[cur.cur]);
                path[cur.cur*2].add(cur.cur*2);
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }

}
