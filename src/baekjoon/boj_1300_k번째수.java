package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class boj_1300_k번째수 {
    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        k=Integer.parseInt(in.readLine());

        int left=1; int right=k;
        while(left<right){
            int mid=(left+right)/2;
            long cnt=0;

            for(int i=1;i<=n;i++){
                cnt+=Math.min(mid/i,n);
            }

            if(cnt<k){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }

        out.write(String.valueOf(left));
        out.close();
        in.close();
    }

}
