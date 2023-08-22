package baekjoon;


import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class boj_14226_이모티콘 {
  static int s;
  static class Node{
      int monitor,clipboard;
      int count;
      Node(int monitor,int clipboard, int count){
          this.monitor=monitor;
          this.clipboard=clipboard;
          this.count=count;
      }
  }
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        s=Integer.parseInt(in.readLine());

        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(1,0,0));

        visit=new boolean[2*s+1][2*s+1];

        int res=-1;
        while(!q.isEmpty()){
            Node cur=q.poll();

            if(cur.monitor==s){
                res= cur.count;
                break;
            }

            if(cur.monitor!=cur.clipboard&&!visit[cur.monitor][cur.monitor]) {
//                System.out.println("복사");
                q.add(new Node(cur.monitor, cur.monitor, cur.count + 1));
                visit[cur.monitor][cur.clipboard]=true;
            }

            int paste=cur.monitor+cur.clipboard;
            if(cur.clipboard!=0&&paste>0&&paste<2*s+1&&!visit[paste][cur.clipboard]){
//                System.out.println("붙여넣기");
                q.add(new Node(paste,cur.clipboard,cur.count+1));
                visit[paste][cur.clipboard]=true;
            }

            if(cur.monitor-1>0&&!visit[cur.monitor-1][cur.clipboard]){
//                System.out.println("하나 빼기");
                q.add(new Node(cur.monitor-1,cur.clipboard,cur.count+1));
                visit[cur.monitor-1][cur.clipboard]=true;
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
