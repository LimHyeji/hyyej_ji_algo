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
    static int[] path;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringBuilder str=new StringBuilder();

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        Queue<Node> q=new ArrayDeque<>();
        boolean[] visit=new boolean[100_001];

        path=new int[100_001];

        q.add(new Node(n,0));
        visit[n]=true;
        Arrays.fill(path,-1);
        path[n]=0;

        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.cur==k){
                Stack<Integer> stack=new Stack<>();
                stack.add(k);

                int n=path[k];
                while(n!=0){
                    stack.add(n);
                    n=path[n];
                }

                str.append(cur.cnt).append("\n");
                while(!stack.isEmpty()){
                    str.append(stack.pop()).append(" ");
                }
                break;
            }

            if(cur.cur-1>=0&&!visit[cur.cur-1]){
                q.add(new Node(cur.cur-1,cur.cnt+1));
                visit[cur.cur-1]=true;
                path[cur.cur-1]=cur.cur;
            }

            if(cur.cur+1<100_001&&!visit[cur.cur+1]){
                q.add(new Node(cur.cur+1,cur.cnt+1));
                visit[cur.cur+1]=true;
                path[cur.cur+1]=cur.cur;
            }

            if(cur.cur*2<100_001&&!visit[cur.cur*2]){
                q.add(new Node(cur.cur*2,cur.cnt+1));
                visit[cur.cur*2]=true;
                path[cur.cur*2]=cur.cur;
            }
        }

        out.write(str.toString());
        out.close();
        in.close();
    }

}
