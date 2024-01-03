package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_16198_에너지모으기 {
    static int n;
    static List<Integer> w;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        n=Integer.parseInt(in.readLine());

        st=new StringTokenizer(in.readLine());
        w=new ArrayList<>();
        for(int i=0;i<n;i++){
            w.add(Integer.parseInt(st.nextToken()));
        }

        res=0;
        solution(w,0);

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    public static void solution(List<Integer> list,int sum){
        if(list.size()==2){
            res=Math.max(res,sum);
            return;
        }

        for(int i=1;i<list.size()-1;i++){
            int temp=list.get(i);
            int tempSum=list.get(i-1)*list.get(i+1);
            list.remove(i);
            solution(list,sum+tempSum);
            list.add(i,temp);
        }
    }
}
