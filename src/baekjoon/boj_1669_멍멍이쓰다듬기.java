package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1669_멍멍이쓰다듬기 {
    static int x,y;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        int dif=y-x;

        min=Integer.MAX_VALUE;
        sol(0,dif-2,1,1,2);
        out.write(String.valueOf(min));
        out.close();
        in.close();
    }

    static void sol(int first,int last, int leftday, int rightday, int day){
        if(first==last){
            if(leftday==rightday)
                min=Math.min(min,day);
            return;
        }

        if(first+leftday<=last-rightday){
            sol(first+leftday,last-rightday,leftday,rightday,day+1);
        }
        if(leftday-1>0&&first+leftday-1<=last-rightday){
            sol(first+leftday-1,last-rightday,leftday-1,rightday,day+1);
        }
        if(first+leftday+1<=last-rightday){
            sol(first+leftday+1,last-rightday,leftday+1,rightday,day+1);
        }

        if(rightday-1>0&&first+leftday<=last-(rightday-1)){
            sol(first+leftday,last-(rightday-1),leftday,rightday-1,day+1);
        }
        if(rightday-1>0&&leftday-1>0&&first+leftday-1<=last-(rightday-1)){
            sol(first+leftday-1,last-(rightday-1),leftday-1,rightday-1,day+1);
        }
        if(rightday-1>0&&first+leftday+1<=last-(rightday-1)){
            sol(first+leftday+1,last-(rightday-1),leftday+1,rightday-1,day+1);
        }

        if(first+leftday<=last-(rightday+1)){
            sol(first+leftday,last-(rightday+1),leftday,rightday+1,day+1);
        }
        if(leftday-1>0&&first+leftday-1<=last-(rightday+1)){
            sol(first+leftday-1,last-(rightday+1),leftday-1,rightday+1,day+1);
        }
        if(first+leftday+1<=last-(rightday+1)){
            sol(first+leftday+1,last-(rightday+1),leftday+1,rightday+1,day+1);
        }
    }
}
