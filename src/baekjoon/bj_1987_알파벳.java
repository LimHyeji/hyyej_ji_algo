package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1987_알파벳 {
    //ascii 65~90
    static int r,c;
    static char[][] board;
    static int res;

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static boolean[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        r=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        board=new char[r][c];
        for(int i=0;i<r;i++){
            String input=in.readLine();
            for(int j=0;j<c;j++){
                board[i][j]=input.charAt(j);
            }
        }
        res=1;
        sel=new boolean[26];
        sel[board[0][0]-'A']=true;
        sol(0,0,1);

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static void sol(int row,int col,int cnt){
        res=Math.max(res,cnt);

      for(int dir=0;dir<4;dir++){
          int newR=dirR[dir]+row;
          int newC=dirC[dir]+col;
          if(newR<0||newR>=r||newC<0||newC>=c||sel[board[newR][newC]-65])
              continue;
          sel[board[newR][newC]-'A']=true;
          sol(newR,newC,cnt+1);
          sel[board[newR][newC]-'A']=false;
      }
    }
}
