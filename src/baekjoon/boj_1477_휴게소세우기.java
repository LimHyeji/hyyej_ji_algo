package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1477_휴게소세우기 {
    static int n,m,len;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        len=Integer.parseInt(st.nextToken());

        list=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        list.add(0);
        list.add(len);
        Collections.sort(list);

        int left=1;
        int right=len-1;
        while(left<=right) {// = 빼먹지 말기
            int mid = (left + right) / 2;

            int sum = 0;
            for (int i = 1; i < list.size(); i++) {
                sum += (list.get(i) - list.get(i - 1) - 1) / mid;
            }

            if (sum > m) {
                //너무 많이 설치하게 되므로, 나누는 수인 mid를 키우기
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        out.write(String.valueOf(left));
        out.close();
        in.close();
    }
}
