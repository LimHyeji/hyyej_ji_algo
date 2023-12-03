package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_18290_NM과K1 {
    static int n,m,k,res;
    static int[][] map;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        map=new int[n][m];
        visit=new boolean[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        res=Integer.MIN_VALUE;
        sol(0,0);
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};

    static void sol(int cnt,int sum){
        if(cnt==k){
            res=Math.max(res,sum);
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]) continue;

                boolean flag=true;
                for(int dir=0;dir<4;dir++){
                    int newR=i+dirR[dir];
                    int newC=j+dirC[dir];
                    if(newR>=0&&newR<n&&newC>=0&&newC<m&&visit[newR][newC]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    visit[i][j]=true;
                    sol(cnt+1,sum+map[i][j]);
                    visit[i][j]=false;
                }
            }
        }
    }
}
