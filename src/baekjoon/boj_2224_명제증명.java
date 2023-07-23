package baekjoon;

import java.io.*;
import java.util.*;

public class boj_2224_명제증명 {
    static int n,x;
    static boolean[][] adj;
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        adj=new boolean[52][52];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int from=convert(st.nextToken());
            String garbage=st.nextToken();
            int to=convert(st.nextToken());

            adj[from][to]=true;
        }

        for(int k=0;k<52;k++){
            for(int i=0;i<52;i++){
                for(int j=0;j<52;j++){
                    if(i==j) continue;
                    if(adj[i][k]&&adj[k][j]){
                        adj[i][j]=true;
                    }
                }
            }
        }

        x=0;
        for(int i=0;i<52;i++){
            for(int j=0;j<52;j++){
                if(i==j) continue;
                if(adj[i][j]){
                    x++;
                    str.append("\n").append(reverse(i)).append(" => ").append(reverse(j));
                }
            }
        }

        out.write(String.valueOf(x));
        out.write(str.toString());
        out.close();
        in.close();
    }

    static int convert(String input){
        char alphabet=input.charAt(0);
        int ascii=alphabet-'A';
        if(ascii<26){//A:0, Z:25
            return ascii;
        }
        else{//a:26, z:51
            return ascii-6;
        }
    }

    static char reverse(int ascii){
        if(ascii<26){
            return (char)(ascii+'A');
        }
        else{
            return (char)(ascii+'A'+6);
        }
    }
}
