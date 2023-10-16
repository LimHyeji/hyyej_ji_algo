package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 게임맵최단거리 {
    class Solution {
        int n,m;
        int[] dirR={-1,1,0,0};
        int[] dirC={0,0,-1,1};

        public int solution(int[][] maps) {
            n=maps.length;
            m=maps[0].length;
            return bfs(maps);
        }

        class Node{
            int row,col,cnt;
            Node(int row,int col,int cnt){
                this.row=row;
                this.col=col;
                this.cnt=cnt;
            }
        }

        public int bfs(int[][] maps){
            Queue<Node> q=new ArrayDeque<>();
            q.add(new Node(0,0,0));

            boolean[][] visit=new boolean[n][m];
            visit[0][0]=true;

            while(!q.isEmpty()){
                Node cur=q.poll();

                if(cur.row==n-1&&cur.col==m-1) return cur.cnt+1;

                for(int dir=0;dir<4;dir++){
                    int newR=cur.row+dirR[dir];
                    int newC=cur.col+dirC[dir];

                    if(newR<0||newR>=n||newC<0||newC>=m||maps[newR][newC]==0||visit[newR][newC]) continue;

                    q.add(new Node(newR,newC,cur.cnt+1));
                    visit[newR][newC]=true;
                }
            }
            return -1;
        }
    }
}
