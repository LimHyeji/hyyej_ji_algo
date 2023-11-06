package baekjoon;

import java.io.*;

public class 팩토리얼0의개수 {
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        m=Integer.parseInt(in.readLine());

        int left=1,right=5*m;
        boolean flag=false;
        while(left<=right){
            int mid=(left+right)/2;

            int cnt=0;
            for(int i=5;i<=mid;i*=5){
                cnt+=(mid/i);
            }

            if(cnt<m){
                left=mid+1;
            }
            else if(cnt==m){
                right=mid-1;
                flag=true;
            }
            else{
                right=mid-1;
            }

            //System.out.println(left+" "+right);
        }
        out.write(String.valueOf(left));
        out.close();
        in.close();
    }
}
