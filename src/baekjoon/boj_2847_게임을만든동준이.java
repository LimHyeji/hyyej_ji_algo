package baekjoon;

import java.io.*;

public class boj_2847_게임을만든동준이 {
    static int n;
    static int[] arr;
    static int res;

    public static void main(String[] args) throws IOException {
        init();
        sol();
        print();
    }

    private static void sol() {
        int cur=arr[n-1];
        for(int idx=n-2;idx>=0;idx--){
            if(arr[idx]>=cur) {
                res+=arr[idx]-cur+1;
                arr[idx]=cur-1;
            }
            cur=arr[idx];
        }
    }

    private static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(String.valueOf(res));
        out.close();
    }

    private static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(in.readLine());
        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }
        in.close();
        res=0;
    }
}
