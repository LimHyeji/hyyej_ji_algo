package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11404_플로이드 {
    static int n,m;
    static int[][] distance;
    static int INF=100_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str=new StringBuilder();
        StringTokenizer st=null;
        n=Integer.parseInt(in.readLine());
        distance=new int[n][n];

        for(int[] arr:distance){
            Arrays.fill(arr,INF);
        }

        m=Integer.parseInt(in.readLine());
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken())-1;
            int b=Integer.parseInt(st.nextToken())-1;
            int cost=Integer.parseInt(st.nextToken());
            if(distance[a][b]==INF) {
                distance[a][b] = cost;
            }
            else{
                distance[a][b]=Math.min(distance[a][b],cost);
            }
        }
        for(int i=0;i<n;i++){
            distance[i][i]=0;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(distance[i][k]+distance[k][j]<distance[i][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               str.append(distance[i][j]==INF?0:distance[i][j]).append(" ");
           }
           str.append("\n");
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
}
