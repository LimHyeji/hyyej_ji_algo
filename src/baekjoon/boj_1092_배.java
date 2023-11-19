package baekjoon;

import java.io.*;
import java.util.*;

public class boj_1092_배 {
    static int n,m;
    static List<Integer> limit,w;
    static int res;

    public static void main(String[] args) throws IOException {
        init();
        sol();
        print();
    }

    public static void init() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        limit=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<n;i++){
            limit.add(Integer.parseInt(st.nextToken()));
        }

        m=Integer.parseInt(in.readLine());
        w=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<m;i++){
            w.add(Integer.parseInt(st.nextToken()));
        }

        res=0;
        in.close();
    }

    public static void sol(){
        Collections.sort(limit,Collections.reverseOrder());
        Collections.sort(w,Collections.reverseOrder());

        if(limit.get(0)<w.get(0)) return;

        while(!w.isEmpty()){
            int idx=0;
            for(int i=0;i<limit.size();){
                if(idx==w.size()) break;
                else if(limit.get(i)>=w.get(idx)){
                    w.remove(idx);
                    i++;
                }
                else idx++;
            }
            res++;
        }

    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        res=res==0?-1:res;
        out.write(String.valueOf(res));
        out.close();
    }
}
