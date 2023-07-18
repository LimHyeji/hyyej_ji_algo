package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2493_탑 {
    static int n;
    static class Top{
        int num;
        int h;
        Top(int num,int h){
            this.num=num;
            this.h=h;
        }
    }
    static Stack<Top> stack;
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());

        stack=new Stack<>();
        st=new StringTokenizer(in.readLine());
        for(int i=1;i<=n;i++) {
            int h = Integer.parseInt(st.nextToken());

            if (stack.isEmpty()) {
                //첫번째 탑에서는 0 출력
                str.append("0 ");
                stack.push(new Top(i, h));
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        //더 높은 탑을 못 찾았을 때 0 출력
                        str.append("0 ");
                        stack.push(new Top(i, h));
                        break;
                    }
                    Top top = stack.peek();
                    if (top.h > h) {
                        //더 높은 탑을 발견한 경우
                        str.append(top.num).append(" ");
                        stack.push(new Top(i, h));
                        break;
                    } else {
                        //나보다 안 높으면 이미 의미 없는 탑이므로 버리기
                        stack.pop();
                    }
                }
            }
        }
        str.append("\n");
        out.write(str.toString());

        out.close();
        in.close();

    }
}
