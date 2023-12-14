package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15810_풍선공장 {
    static int n,m;
    static int[] time;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        time=new int[n];
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            time[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time);

        long left=0;
        long right=(long)time[0]*(long)m;

        while(left<=right){
            long mid=(left+right)/2;

            long sum=0;
            for(int i=0;i<n;i++){
                sum+=mid/(long)time[i];
            }

            if(sum>=m) right=mid-1;
            else left=mid+1;
        }

        out.write(String.valueOf(left));;
        out.close();
        in.close();
    }
}
