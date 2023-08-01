package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_19699_소난다 {
    static int n,m;
    static int [] arr;
    static boolean[] sel;
    static int[] num;
    static StringBuilder str=new StringBuilder();
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n];
        sel=new boolean[n];
        num=new int[m];

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        check=new boolean[10000];
        com(0,0);

        int cnt=0;
        for(int i=0;i<10000;i++){
            if(check[i]) {
                str.append(i).append(" ");
                cnt++;
            }
        }
        if(cnt==0) str.append(-1);
        out.write(str.toString());
        out.close();
        in.close();
    }

    static void com(int start,int cnt){
        if(cnt==m){
            //System.out.println(Arrays.toString(num));
            checkPrime(num);
            return;
        }
        for(int i=start;i<n;i++){
            if(sel[i]) continue;
            num[cnt]=i;
            sel[i]=true;
            com(i+1,cnt+1);
            sel[i]=false;
        }
    }

    static void checkPrime(int[] num){
        int sum=0;
        for(int i=0;i<m;i++){
            sum+=arr[num[i]];
        }
        if(check[sum]) return;

        for(int i=2;i<=sum/2;i++){
            if(sum%i==0){
                return;
            }
        }
        check[sum]=true;
    }
}
