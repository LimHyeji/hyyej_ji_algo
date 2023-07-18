package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1174_줄어드는수 {
    /*
    한자리수이면, n+1 출력
    두자리수 이상이면,
     */
    static int n;
    static int[] num={9,8,7,6,5,4,3,2,1,0};
    static ArrayList<Long> list=null;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
       // BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(in.readLine());

        if(n>=1024) {
            System.out.println(-1);
        }else{
            list=new ArrayList<>();
            dfs(0,0);
            Collections.sort(list);
            System.out.println(list.get(n-1));
        }

        in.close();
    }

    static void dfs(long res, int cnt){
        if(!list.contains(res)){
            list.add(res);
        }

        if(cnt>=10){
            return;
        }

        dfs(res*10+num[cnt],cnt+1);
        dfs(res,cnt+1);
    }
}
