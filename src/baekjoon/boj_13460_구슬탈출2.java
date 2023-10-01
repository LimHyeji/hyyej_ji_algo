package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_13460_구슬탈출2 {
    static int n,m;
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
    static Node blue,red;
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
                if(map[i][j]=='B'){
                    blue=new Node(i,j);
                }
                else if(map[i][j]=='R'){
                    red=new Node(i,j);
                }
                else map[i][j]=input.charAt(j);
            }
        }

        res=Integer.MAX_VALUE;
        sol(blue,red,0);
        out.write(String.valueOf(res==Integer.MAX_VALUE?-1:res));
        out.close();
        in.close();
    }

    private static void sol(Node blue, Node red, int cnt) {
        if(cnt>10) return;

        for(int dir=0;dir<4;dir++){
            int blueR=blue.row;
            int blueC=blue.col;
            int redR=red.row;
            int redC=red.col;

            boolean checkBlue=false, checkRed=false;
            boolean possible=true;
            while(true){
                if(checkBlue&&checkRed) break;

                if(map[blueR+dirR[dir]][blueC+dirC[dir]]!='#'){
                    blueR+=dirR[dir];
                    blueC+=dirC[dir];
                }
                else checkBlue=true;
                if(map[redR+dirR[dir]][redC+dirC[dir]]!='#'){
                    redR+=dirR[dir];
                    redC+=dirC[dir];
                }
                else checkRed=true;

                if(map[blueR][blueC]=='O'){
                    possible=false;
                    break;
                }

                if(blueR==redR&&blueC==redC) {
                    possible=false;
                    break;
                }

                if(map[redR][redC]=='O'){
                    res=Math.min(res,cnt+1);
                    possible=false;
                    break;
                }
            }

            if(possible){
                if(cnt+1<=10){
                    sol(new Node(blueR,blueC),new Node(redR,redC),cnt+1);
                }
            }
        }
    }
}
