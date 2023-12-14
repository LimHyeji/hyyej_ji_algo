package etc.codetree;

import java.io.*;
import java.util.StringTokenizer;

public class 조삼모사 {
    static int n;
    static int[][] p;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        p=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                p[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        sel=new boolean[n];
        res=Integer.MAX_VALUE;

        com(0,0);
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static boolean[] sel;
    static void com(int cur,int cnt){
        if(cnt==n/2){
            res=Math.min(res,sol());
            return;
        }

        if(cur==n) return;

        com(cur+1,cnt);

        sel[cur]=true;
        com(cur+1,cnt+1);
        sel[cur]=false;
    }

    static int sol(){
        int a=0,b=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!sel[i]&&!sel[j]){
                    a+=p[i][j];
                }
                if(sel[i]&&sel[j]){
                    b+=p[i][j];
                }
            }
        }
        return Math.abs(a-b);
    }
}
