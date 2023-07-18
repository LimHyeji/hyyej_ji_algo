package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1863_스카이라인쉬운거 {

    static int n;
    static Stack<Integer> s;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));

        n=Integer.parseInt(in.readLine());
        s=new Stack<>();
        res=0;

        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(y==0){
                res+=s.size();
                s.clear();
                continue;
            }

            while (!s.isEmpty() && (s.peek() > y)) {
                s.pop();
                res++;
            }
            if(!s.isEmpty()&&s.peek()==y){
                continue;
            }
            s.push(y);
        }

        res+=s.size();
        s.clear();

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
