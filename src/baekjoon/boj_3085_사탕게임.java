package baekjoon;

import java.io.*;

public class boj_3085_사탕게임 {
    static int n;
    static char[][] map;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        map=new char[n][n];
        for(int i=0;i<n;i++){
            String input=in.readLine();
            for(int j=0;j<n;j++){
                map[i][j]=input.charAt(j);
            }
        }

        max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                char temp=map[i][j];
                map[i][j]=map[i][j+1];
                map[i][j+1]=temp;

                check();

                temp=map[i][j];
                map[i][j]=map[i][j+1];
                map[i][j+1]=temp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                char temp=map[j][i];
                map[j][i]=map[j+1][i];
                map[j+1][i]=temp;

                check();

                temp=map[j][i];
                map[j][i]=map[j+1][i];
                map[j+1][i]=temp;
            }
        }

        out.write(String.valueOf(max));
        out.close();
        in.close();
    }

    static void check(){
        for(int i=0;i<n;i++){
            int cnt=1;
            for(int j=0;j<n-1;j++){
                if(map[i][j]==map[i][j+1]) cnt++;
                else cnt=1;
                max=Math.max(max,cnt);
            }
        }

        for(int i=0;i<n;i++){
            int cnt=1;
            for(int j=0;j<n-1;j++){
                if(map[j][i]==map[j+1][i]) cnt++;
                else cnt=1;
                max=Math.max(max,cnt);
            }
        }
    }

    static void swap(char a,char b){
        char temp=a;
        a=b;
        b=temp;
    }
}
