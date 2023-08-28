package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14719_빗물 {
    static int h,w;
    static int[] arr;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        h=Integer.parseInt(st.nextToken());
        w=Integer.parseInt(st.nextToken());
        arr=new int[w];

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<w;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        res=0;
        for(int i=1;i<w-1;i++){
            int left_val=arr[i];
            for(int left=0;left<i;left++){
                left_val=Math.max(left_val,arr[left]);
            }

            int right_val=arr[i];
            for(int right=i+1;right<w;right++){
                right_val=Math.max(right_val,arr[right]);
            }

            int mid=Math.min(left_val,right_val);
            res+=Math.abs(mid-arr[i]);
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
