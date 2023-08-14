package baekjoon;

import java.io.*;

public class boj_2581_소수 {
    static int n,m;
    static int min;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str=new StringBuilder();
        m=Integer.parseInt(in.readLine());
        n=Integer.parseInt(in.readLine());
        min=-1;
        sum=0;
        for(int i=m;i<=n;i++){
            if(check(i)){
                if(min==-1) min=i;
                sum+=i;
            }
        }

        if(min==-1){
            str.append(-1);
        }
        else {
            str.append(sum).append("\n").append(min);
        }
        out.write(str.toString());
        out.close();
        in.close();
    }

    static boolean check(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
