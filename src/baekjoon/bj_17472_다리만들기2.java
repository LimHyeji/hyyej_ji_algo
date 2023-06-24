package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj_17472_다리만들기2 {
static int n,m;
static int[][] map;
static int idx=2;

static class Edge implements Comparable<Edge>{
    int u,v,w;

    Edge(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.w,o.w);
    }
}
static ArrayList<Edge> list;

static int[] par;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map=new int[n][m];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    dfs(i,j,idx++);
                }
            }
        }

        //print();

        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]>1){
                    connect(i,j,map[i][j]);
                }
            }
        }

        Collections.sort(list);
//        for(Edge e:list){
//            System.out.println(e.u+" "+e.v+" "+e.w);
//        }

        par=new int[idx];
        for(int i=2;i<idx;i++){
            par[i]=i;
        }
      //  System.out.println(Arrays.toString(par));

        int size=list.size();
        int cnt=0;
        int res=0;
        for(int i=0;i<size;i++){
            if(union(list.get(i).u,list.get(i).v)){
                res+=list.get(i).w;
                cnt++;
            }
            if(cnt==idx-3){
                System.out.println(res);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }

    static int[] dirR={-1,1,0,0};
    static int[] dirC={0,0,-1,1};
    static void dfs(int i,int j,int idx){
        map[i][j]=idx;
        for(int dir=0;dir<4;dir++){
            int newR=dirR[dir]+i;
            int newC=dirC[dir]+j;
            if(newR<0||newR>=n||newC<0||newC>=m||map[newR][newC]!=1){
                continue;
            }
            dfs(newR,newC,idx);
        }
    }

    static void connect(int i,int j,int name){
        for(int dir=0;dir<4;dir++){
            int len=0;
            int newR=i;
            int newC=j;
            while(true){
                newR+=dirR[dir];
                newC+=dirC[dir];
                if(newR<0||newR>=n||newC<0||newC>=m||map[newR][newC]==name){
                    break;
                }
                if(map[newR][newC]>1){
                    if(len>1) {
                        list.add(new Edge(name, map[newR][newC], len));
                    }
                    break;
                }
                len++;
            }
        }
    }

    static int find(int i){
        if(par[i]==i) return i;
        return find(par[i]);
    }

    static boolean union(int a,int b){
        int aPar=find(a);
        int bPar=find(b);
        if(aPar==bPar) return false;
        else{
           // System.out.println("a"+a+" b"+b);

            if(aPar<bPar){
                par[b]=aPar;
                for(int i=2;i<idx;i++){
                    if(par[i]==bPar){
                        par[i]=aPar;
                    }
                }
            }
            else{
                par[a]=bPar;
                for(int i=2;i<idx;i++){
                    if(par[i]==aPar){
                        par[i]=bPar;
                    }
                }
            }
          //  System.out.println(Arrays.toString(par));
            return true;
        }
    }


    static void print(){
        for(int[] arr:map){
            System.out.println(Arrays.toString(arr));
        }
    }
}

