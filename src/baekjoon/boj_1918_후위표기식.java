package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Stack;

public class boj_1918_후위표기식 {
    static char[] input;
    static Stack<Character> operation;
    static HashMap<Character,Integer> priority=new HashMap<>(){{
            put('*',3);
            put('/',3);
            put('+',2);
            put('-',2);
            put('(',1);
    }};
    static StringBuilder str=new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        input=in.readLine().toCharArray();

        operation=new Stack<>();

        for(int i=0;i<input.length;i++){
            if(input[i]>=65&&input[i]<=90){
                str.append(input[i]);
            }
            else{
                switch (input[i]){
                    case '(':
                        operation.push(input[i]);
                        break;
                    case ')':
                        while(operation.peek()!='('){
                            char temp=operation.pop();
                            str.append(temp);
                        }
                        operation.pop();
                        break;
                    default:
                        if(operation.isEmpty()){
                            operation.push(input[i]);
                        }
                        else{
                            char temp=operation.pop();
                            if(temp=='('){
                                operation.push(temp);
                                operation.push(input[i]);
                            }
                            else if(priority.get(temp)>=priority.get(input[i])){
                                str.append(temp);
                                while(true){
                                    if(operation.isEmpty()) break;
                                    temp=operation.pop();
                                    if(priority.get(temp)>=priority.get(input[i])){
                                        str.append(temp);
                                    }
                                    else {
                                        operation.push(temp);
                                        break;
                                    }
                                }
                                operation.push(input[i]);
                            }
                            else{
                                operation.push(temp);
                                operation.push(input[i]);
                            }
                        }
                        break;
                }
            }
        }

        while(!operation.isEmpty()){
            str.append(operation.pop());
        }

        out.write(str.toString());
        out.close();
        in.close();

    }
}
