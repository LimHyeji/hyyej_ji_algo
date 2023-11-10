package baekjoon;

import java.io.*;
import java.util.*;

public class boj_10653_마라톤2 {
    static int n,k;
    static class Node{
        int x,y;
        Node(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    static List<Node> list;
    static int getDistance(int a,int b){
        if(distance[a][b] == -1) {
            int dis = Math.abs(list.get(a).x-list.get(b).x) + Math.abs(list.get(a).y-list.get(b).y);
            distance[a][b] = dis;
            distance[b][a] = dis;
        }
        return distance[a][b];
    }
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        list=new ArrayList<>();
        distance=new int[n][n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            list.add(new Node(x,y));
            for(int j=0;j<n;j++){
                distance[i][j]=-1;
            }
        }

        int[][] dp=new int[k+1][n];
        for(int i=0;i<=k;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
                if(i==0) dp[i][0]=0;
            }
        }

        int min,temp;
        for(int i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                if(i>j){
                    min=Integer.MAX_VALUE;
                    for(int l=0;l<=j;l++){
                        temp=dp[j-l][i-l-1];
                        if(temp==-1) continue;
                        min=Math.min(min,temp+getDistance(i-l-1,i));
                    }
                    dp[j][i]=min;
                }
            }
        }

        int result=dp[0][n-1];
        for(int i=1;i<=k;i++){
            if(dp[i][n-1]<result) result=dp[i][n-1];
        }

        out.write(String.valueOf(result));
        out.close();
        in.close();
    }
}
