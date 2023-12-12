package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_10703_유성 {
    static int r,s;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        r=Integer.parseInt(st.nextToken());
        s=Integer.parseInt(st.nextToken());

        map=new char[r][s];
        for(int i=0;i<r;i++){
            String input=in.readLine();
            for(int j=0;j<s;j++){
                map[i][j]=input.charAt(j);
            }
        }

        int diff=Integer.MAX_VALUE;
        for(int j=0;j<s;j++){
            for(int i=r-1;i>=0;i--){
                if(map[i][j]=='X'){
                    int h=i;
                    while(true){
                        h++;
                        if(h>=r) break;

                        if(map[h][j]=='.'){
                            continue;
                        }
                        else{
                            break;
                        }
                    }
                    h--;
                    if(h!=0) {
                        diff=Math.min(diff,Math.abs(i-h));
                        break;
                    }
                }
            }
        }
        diff=diff==Integer.MAX_VALUE?0:diff;

        for(int j=0;j<s;j++){
            for(int i=r-1;i>=0;i--){
                if(map[i][j]=='X'){
                    map[i][j]='.';
                    map[i+diff][j]='X';
                }
            }
        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<r;i++){
            for(int j=0;j<s;j++){
                str.append(map[i][j]);
            }
            str.append('\n');
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
}
