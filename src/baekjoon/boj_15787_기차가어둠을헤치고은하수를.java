package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_15787_기차가어둠을헤치고은하수를 {
    static int n,m;
    static HashSet<Integer>[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        trains=new HashSet[n];
        for(int i=0;i<n;i++){
            trains[i]=new HashSet<>();
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(in.readLine());
            int cmd=Integer.parseInt(st.nextToken());
            int num=Integer.parseInt(st.nextToken())-1;

            if(cmd==1){
                int x=Integer.parseInt(st.nextToken());
                trains[num].add(x);
            }
            else if(cmd==2){
                int x=Integer.parseInt(st.nextToken());
                trains[num].remove(x);
            }
            else if(cmd==3){
                HashSet<Integer> copy=trains[num];
                trains[num].clear();
                for(int e:copy){
                    if(e+1==20) continue;
                    trains[num].add(e+1);
                }
            }
            else{
                HashSet<Integer> copy=trains[num];
                trains[num].clear();
                for(int e:copy){
                    if(e-1<0) continue;
                    trains[num].add(e-1);
                }
            }
        }

        boolean[] check=new boolean[n];
        int cnt=0;

        check[0]=true;
        cnt++;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(check[j]){
                    if(trains[i].size()!=trains[j].size()||!trains[i].containsAll(trains[j])){
                        check[i]=true;
                        cnt++;
                    }
                }
            }
        }
        out.write(String.valueOf(cnt));
        out.close();
        in.close();
    }
}
