package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class 무인도여행 {

    class Solution {
        int[] dirR={-1,1,0,0};
        int[] dirC={0,0,-1,1};
        int n,m;
        char[][] map;
        ArrayList<Integer> list;

        public int[] solution(String[] maps) {
            int[] answer;

            n=maps.length;
            m=maps[0].length();

            map=new char[n][m];
            list=new ArrayList<>();

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    map[i][j]=maps[i].charAt(j);
                }
            }

            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]!='X'){
                        list.add(bfs(i,j));
                    }
                }
            }

            Collections.sort(list);

            if(list.size()==0){
                answer=new int[1];
                answer[0]=-1;
            }
            else{
                answer=new int[list.size()];
                for(int idx=0;idx<list.size();idx++){
                    answer[idx]=list.get(idx);
                }
            }

            return answer;
        }

        class Node{
            int row,col;
            Node(int row,int col){
                this.row=row;
                this.col=col;
            }
        }
        int bfs(int row,int col){
            Queue<Node> q=new ArrayDeque<>();

            q.add(new Node(row,col));
            int max=map[row][col]-'0';
            map[row][col]='X';

            while(!q.isEmpty()){
                Node cur=q.poll();

                for(int dir=0;dir<4;dir++){
                    int newR=cur.row+dirR[dir];
                    int newC=cur.col+dirC[dir];

                    if(newR<0||newR>=n||newC<0||newC>=m||map[newR][newC]=='X'){
                        continue;
                    }

                    q.add(new Node(newR,newC));
                    max+=map[newR][newC]-'0';
                    map[newR][newC]='X';
                }
            }
            return max;
        }
    }
}
