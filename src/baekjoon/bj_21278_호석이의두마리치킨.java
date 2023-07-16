package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_21278_호석이의두마리치킨 {
  static int n,m;
  static int[][] distance;
  static int a,b,sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        StringBuilder str=new StringBuilder();
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        distance=new int[n+1][n+1];
        for(int[] arr:distance){
            Arrays.fill(arr,1000_000_000);
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            distance[from][to]=1;
            distance[to][from]=1;
        }

        for(int i=1;i<n+1;i++){
            distance[i][i]=0;
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(distance[i][k]+distance[k][j]<distance[i][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }

//        for(int[] arr:distance){
//            System.out.println(Arrays.toString(arr));
//        }

        num=new int[2];
        a=-1;b=-1;sum=Integer.MAX_VALUE;
        com(0,1);

        str.append(a).append(" ").append(b).append(" ").append(sum*2);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static int[] num;
    static void com(int cnt,int start){
        if(cnt==2){
            sol(num);
//            System.out.println("만들어진 조합 : "+Arrays.toString(num));
            return;
        }

        for(int i=start;i<n+1;i++){
            num[cnt]=i;
            com(cnt+1,i+1);
        }
    }

    static void sol(int[] plan){
        int cnt=0;
        for(int i=1;i<n+1;i++){
                cnt+=Math.min(distance[i][plan[0]],distance[i][plan[1]]);
        }

        if((sum>cnt)||(sum==cnt)&&(plan[0]<a||(plan[0]==a&&plan[1]<b))){
            a=plan[0];
            b=plan[1];
            sum=cnt;
        }
       // System.out.println("만들어진 경우 : "+a+", "+b+", "+sum);
    }
}
