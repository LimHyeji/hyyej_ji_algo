package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class bj_1012_유기농배추 {
    static int t,m,n,k;
    static int[][] map;
    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static StringBuilder str;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        str=new StringBuilder();

        t=Integer.parseInt(in.readLine());

        for(int test_case=1;test_case<=t;test_case++){
            st=new StringTokenizer(in.readLine());
            m=Integer.parseInt(st.nextToken());
            n=Integer.parseInt(st.nextToken());
            k=Integer.parseInt(st.nextToken());
            map=new int[n][m];
            for(int i=0;i<k;i++){
                st=new StringTokenizer(in.readLine());

                int col=Integer.parseInt(st.nextToken());
                int row=Integer.parseInt(st.nextToken());
                map[row][col]=1;
            }

            int cnt=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j]==1){
                        map[i][j]=-1;
                        dfs(i,j);
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

    static void dfs(int row,int col){
        for(int dir=0;dir<4;dir++){
            int newR=row+dirR[dir];
            int newC=col+dirC[dir];

            if(newR<0||newR>=n||newC<0||newC>=m||map[newR][newC]!=1)
                continue;

            map[newR][newC]=-1;
            dfs(newR,newC);
        }
    }
}
