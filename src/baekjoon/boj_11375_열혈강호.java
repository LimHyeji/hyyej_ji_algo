package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11375_열혈강호 {
    static int n,m;
    static ArrayList<Integer> [] adj;
    static boolean[] visit;
    static int[] left,right;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        adj=new ArrayList[n];
        for(int i=0;i<adj.length;i++){
            adj[i]=new ArrayList<>();
        }

        left=new int[n];
        right=new int[m];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int size=Integer.parseInt(st.nextToken());
            for(int j=0;j<size;j++){
                int input=Integer.parseInt(st.nextToken())-1;
                adj[i].add(input);
            }
        }

        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        int cnt=0;
        for(int i=0;i<n;i++){
            if(left[i]==-1){
                visit=new boolean[n];
                if(dfs(i)) cnt++;
            }
        }

        out.write(String.valueOf(cnt));
        out.close();
        in.close();
    }

    static boolean dfs(int a){
        visit[a]=true;

        for(int b:adj[a]){
            if(right[b]==-1||(!visit[right[b]]&&dfs(right[b]))){
                left[a]=b;
                right[b]=a;
                return true;
            }
        }
        return false;
    }
}

