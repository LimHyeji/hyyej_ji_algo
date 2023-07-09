package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_1863_스카이라인쉬운거 {
    /*
    스택 활용
    1. 첫 좌표의 y>0이면 stack에 push
    2. 입력값이 증가하면 stack에 push
    3. 입력값이 감소하면 stack에서 pop(건물의 개수++)
    4. 마지막 좌표의 y>0이면 건물의 개수++
     */

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
            if(i==0){
                if(y>0) s.push(y);
            }
            else if(i==n-1){
                if(s.peek()>0) res++;
            }
            else{
                if(s.peek()>y){//감소
                    s.pop();
                    if(s.peek()!=y)
                        s.push(y);
                    res++;
                }
                else{//증가
                    s.push(y);
                }
            }
            System.out.println(x+", "+y+"일 때");
            for(int ss:s){
                System.out.print(ss+ " ");
            }
            System.out.println();
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
