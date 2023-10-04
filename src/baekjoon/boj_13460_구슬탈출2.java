package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_13460_구슬탈출2 {
    static int n,m;
    static char[][] map;
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static Node blue,red;

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new char[n][m];

        for(int i=0;i<n;i++){
            String input=in.readLine();
            for(int j=0;j<m;j++){
                map[i][j]=input.charAt(j);
                if(map[i][j]=='R'){
                    red=new Node(i,j);
                }
                else if(map[i][j]=='B'){
                    blue=new Node(i,j);
                }
            }
        }

        res=Integer.MAX_VALUE;
        sol(map,red,blue,0);
        out.write(String.valueOf(res==Integer.MAX_VALUE?-1:res));
        out.close();
        in.close();
    }

    /**
     * 해당하는 방향으로 R, B 함께 이동하되, 벽을 만났을 경우 체크하기 (둘 다 벽을 만나면 이동 끝)
     * 빨간 구슬이 들어가도 파란 구슬이 이동 끝날 때까지 확인하기
     * */
    static void sol(char[][] map,Node red,Node blue, int cnt){
        if(cnt>10) return;

        for(int dir=0;dir<4;dir++){
            int r_row=red.row;
            int r_col=red.col;
            int b_row=blue.row;
            int b_col=blue.col;

            boolean impossible=false;
            boolean r_check=false,b_check=false;
            while(true){
                if(r_check&&b_check) break;

                if(!r_check) {
                    r_row += dirR[dir];
                    r_col += dirC[dir];
                }
                if(!b_check) {
                    b_row += dirR[dir];
                    b_col += dirC[dir];
                }

                if(!r_check&&map[r_row][r_col]=='#'){
                    r_row-=dirR[dir];
                    r_col-=dirC[dir];
                    r_check=true;
                }

                if(!b_check&&map[b_row][b_col]=='#'){
                    b_row-=dirR[dir];
                    b_col-=dirC[dir];
                    b_check=true;
                }

                if(map[b_row][b_col]=='O'||r_row==b_row&&r_col==b_col){
                    impossible=true;
                    break;
                }

                if(!r_check&&map[r_row][r_col]=='O'){
                    impossible=true;
                    r_check=true;
                    res=Math.min(res,cnt+1);
                    r_row=-1;
                    r_col=-1;
                }
            }

            if(!impossible){
                char[][] copy=copy(map);
                copy[red.row][red.col]='.';
                copy[r_row][r_col]='R';
                copy[blue.row][blue.col]='.';
                copy[b_row][b_col]='B';
                sol(copy,new Node(r_row,r_col),new Node(b_row,b_col),cnt+1);
            }
        }
    }

    static char[][] copy(char[][] map){
        char[][] copy=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j]=map[i][j];
            }
        }
        return copy;
    }
}

/*
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######

5
 */
