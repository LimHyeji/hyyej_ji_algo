package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11123_양한마리양두마리 {
    static int t,h,w;
    static char[][] map;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        StringBuilder str=new StringBuilder();

        t=Integer.parseInt(in.readLine());
        for(int test_case=1;test_case<=t;test_case++){
            st=new StringTokenizer(in.readLine());
            h=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            map=new char[h][w];
            for(int i=0;i<h;i++){
                String input=in.readLine();
                for(int j=0;j<w;j++){
                    map[i][j]=input.charAt(j);
                }
            }

            int cnt=0;
            for(int i=0;i<h;i++){
                for(int j=0;j<w;j++){
                    if(map[i][j]=='#'){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            str.append(cnt).append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void bfs(int row,int col){
        Queue<Node> q=new ArrayDeque<>();
        q.add(new Node(row,col));
        map[row][col]='.';
        while(!q.isEmpty()){
            Node cur=q.poll();
            for(int dir=0;dir<4;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];
                if(newR<0||newR>=h||newC<0||newC>=w||map[newR][newC]=='.'){
                    continue;
                }
                q.add(new Node(newR,newC));
                map[newR][newC]='.';
            }
        }
    }
}
