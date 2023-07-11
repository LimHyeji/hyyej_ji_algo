package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_16951_블록놀이 {
    static int n,k;
    static int[] arr;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        res=Integer.MAX_VALUE;
        arr=new int[n];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int[] copy=new int[n];

        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                copy[j]=arr[j];
            }

            for(int j=i;j>0;j--){
                if(copy[j]-copy[j-1]!=k){
                    cnt++;
                    copy[j-1]=copy[j]-k;
                }
            }
            for(int j=i+1;j<n;j++){
                if(copy[j]-copy[j-1]!=k){
                    cnt++;
                    copy[j]=copy[j-1]+k;
                }
            }
//            System.out.println(i+"th");
//            System.out.println(Arrays.toString(copy));
            boolean flag=true;
            for(int j=0;j<n;j++){
                if(copy[j]<1){
                    flag=false;
                }
            }
            if(flag) {
                res = Integer.min(res, cnt);
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
