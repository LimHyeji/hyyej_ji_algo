package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14621_나만안되는연애 {
    static int n,m;
    static char[] gender;
    static class Edge implements Comparable<Edge>{
        int u,v,d;
        Edge(int u,int v, int d){
            this.u=u;
            this.v=v;
            this.d=d;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.d,o.d);
        }
    }
    static List<Edge> list;
    static int[] par;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        par=new int[n+1];
        for(int i=1;i<n+1;i++){
            par[i]=i;
        }

        gender=new char[n+1];
        st=new StringTokenizer(in.readLine());
        for(int i=1;i<n+1;i++){
            char c=st.nextToken().charAt(0);
            gender[i]=c;
        }

        list=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int d=Integer.parseInt(st.nextToken());
            if(gender[u]!=gender[v]) {
                list.add(new Edge(u, v, d));
            }
        }

        Collections.sort(list);

        res=0;
        for(int i=0;i<list.size();i++){
            if(union(list.get(i).u,list.get(i).v)){
                res+=list.get(i).d;
            }
        }

        int cur=par[1];
        for(int i=2;i<n+1;i++){
            if(par[i]!=cur) res=-1;
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static int find(int num){
        if(par[num]==num) return num;
        return par[num]=find(par[num]);
    }

    static boolean union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(parA==parB) return false;
        if(parA<parB){
         par[b]=parA;
         for(int i=1;i<n+1;i++){
             if(par[i]==parB){
                 par[i]=parA;
             }
         }
        }
        else{
            par[a]=parB;
            for(int i=1;i<n+1;i++){
                if(par[i]==parA){
                    par[i]=parB;
                }
            }
        }
        return true;
    }
}
