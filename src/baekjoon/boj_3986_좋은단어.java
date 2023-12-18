package baekjoon;

import java.io.*;
import java.util.Stack;

public class boj_3986_좋은단어 {
    static int n,res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        res=0;
        for(int i=0;i<n;i++){
            char[] word=in.readLine().toCharArray();
            if(check(word)) res++;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    public static boolean check(char[] word){
        int size=word.length;

        if(size%2==1) return false;

        Stack<Character> stack=new Stack<>();

        for(int i=0;i<size;i++){
            if(stack.isEmpty()) stack.add(word[i]);
            else{
                if(stack.peek()==word[i]) stack.pop();
                else stack.push(word[i]);
            }
        }

        if(!stack.isEmpty()) return false;

        return true;
    }
}
