package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
    static int n,m;
    static boolean[][] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        sel=new boolean[n+1][n+1];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            sel[a][b]=true;
            sel[b][a]=true;
        }

        int res=0;
        for(int i=1;i<n+1;i++){
            for(int j=i+1;j<n+1;j++){
                if(sel[i][j]) continue;
                for(int k=j+1;k<n+1;k++){
                    if(sel[j][k]||sel[k][i]) continue;
                    res++;
                }
            }
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
