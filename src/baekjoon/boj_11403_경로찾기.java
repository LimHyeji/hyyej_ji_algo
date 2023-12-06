package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11403_경로찾기 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        n=Integer.parseInt(in.readLine());

        int[][] distance=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            for(int j=0;j<n;j++){
                int input=Integer.parseInt(st.nextToken());
                if(input==1) distance[i][j]=1;
                else distance[i][j]=100_000_000;
            }
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
                System.out.print((distance[i][j]==100_000_000?0:1)+" ");
            }
            System.out.println();
        }
    }
}
