package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_20551_Sort마스터배지훈의후계자 {
    static int n,m;
    static int[] arr;
    static HashMap<Integer,Integer> map;
    static StringBuilder str;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(in.readLine());
        }

        Arrays.sort(arr);

        map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(map.get(arr[i])==null){
                map.put(arr[i],i);
            }
        }

        str=new StringBuilder();
        for(int i=0;i<m;i++){
            int d=Integer.parseInt(in.readLine());
            if(map.get(d)==null) str.append(-1);
            else str.append(map.get(d));
            str.append("\n");
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
