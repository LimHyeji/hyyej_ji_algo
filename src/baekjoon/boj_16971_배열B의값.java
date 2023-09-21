package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16971_배열B의값 {
    static int n,m;
    static int[][] arr;
    static int[] num;
    static boolean[] sel;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        num=new int[2];
        max=Integer.MIN_VALUE;

        sel=new boolean[n];
        confrimRow(0,0);

        sel=new boolean[m];
        confirmCol(0,0);

        out.write(String.valueOf(max));
        out.close();
        in.close();
    }

    private static void confrimRow(int cnt, int start) {
        if(cnt==2){
            int[][] copy=copyArr();

            int first=num[0];
            int second=num[1];
            for(int i=0;i<m;i++){
                copy[first][i]=arr[second][i];
                copy[second][i]=arr[first][i];
            }

            max=Math.max(max,getMax(copy));
            return;
        }

        for(int i=start;i<n;i++){
            if(sel[i]) continue;
            num[cnt]=i;
            sel[i]=true;
            confrimRow(cnt+1,i+1);
            sel[i]=false;
        }
    }

    private static void confirmCol(int cnt, int start) {
        if(cnt==2){
            int[][] copy=copyArr();

            int first=num[0];
            int second=num[1];
            for(int i=0;i<n;i++){
                copy[i][first]=arr[i][second];
                copy[i][second]=arr[i][first];
            }

            max=Math.max(max,getMax(copy));
            return;
        }

        for(int i=start;i<m;i++){
            if(sel[i]) continue;
            num[cnt]=i;
            sel[i]=true;
            confirmCol(cnt+1,i+1);
            sel[i]=false;
        }

    }

    private static int getMax(int[][] copy) {
        int sum=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                sum=sum+copy[i][j]+copy[i][j+1]+copy[i+1][j]+copy[i+1][j+1];
            }
        }
        return sum;
    }

    private static int[][] copyArr() {
        int[][] copy=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j]=arr[i][j];
            }
        }
        return copy;
    }
}
