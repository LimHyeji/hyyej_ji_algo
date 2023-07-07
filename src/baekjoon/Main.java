package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in;
    static BufferedWriter out;
    StringBuilder str=new StringBuilder();

    static int n,m;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        in=new BufferedReader(new InputStreamReader(System.in));
        out=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        adj=new int[n+1][n+1];
        for(int[] arr:adj){
            Arrays.fill(arr,1_000_000);
        }

        for(int i=1;i<n+1;i++){
            adj[i][i]=0;
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());

                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());
                adj[a][b]=1;
                adj[b][a]=1;
        }

        cal();
        num=new int[2];
        com(0,1);


        out.close();
        in.close();
    }

    static void cal(){
        for(int k=1;k<n+1;k++){
        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                    if(adj[i][k]+adj[k][j]<adj[i][j]){
                        adj[i][j]=adj[i][k]+adj[k][j];
                    }
                }
            }
        }
    }

    static int[] num;
    static void com(int cnt,int start){
        if(cnt==2){

            return;
        }
        for(int i=start;i<n+1;i++){
            num[cnt]=i;
            com(cnt+1,i+1);
        }
    }
}
