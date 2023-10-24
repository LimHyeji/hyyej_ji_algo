package baekjoon;

import java.io.*;

public class boj_2018_수들의합5 {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(in.readLine());

        int start=1,end=1;
        int sum=1,cnt=0;
        while(start<=end){
            if(sum==n) cnt++;

            if(sum<n){//합이 기준보다 작으면
                end++;//오른쪽 포인터 이동
                sum+=end;
            }
            else{//합이 기준보다 작으면
                sum-=start;//왼쪽 포인터 이동
                start++;
            }
        }

        out.write(String.valueOf(cnt));
        out.close();
        in.close();
    }
}
