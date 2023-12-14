package etc.codetree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 외주수익최대화하기 {
    static int n;
    static List<Integer> select;
    static class Work{
        int start,end;
        int profit;
        Work(int start,int end,int profit){
            this.start=start;
            this.end=end;
            this.profit=profit;
        }
    }
    static List<Work> works;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n=Integer.parseInt(in.readLine());
        works=new ArrayList<>();

        for(int i=1;i<n+1;i++){
            st=new StringTokenizer(in.readLine());
            int start=i;
            int end=Integer.parseInt(st.nextToken());
            int profit=Integer.parseInt(st.nextToken());
            //if(start+end-1>n) continue;

            works.add(new Work(start,start+end-1,profit));
        }

        select=new ArrayList<>();
        res=0;
        dfs(0);

        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

    static void dfs(int cnt){
        if(cnt==n){
            if(check(select)){
                res=Math.max(res,getProfit(select));
            }
            return;
        }

        dfs(cnt+1);

        if(check(select)){
            select.add(cnt);
            dfs(cnt+1);
            select.remove(select.size()-1);
        }

    }

    static int getProfit(List<Integer> select){
        int profits=0;
        for(int i=0;i<select.size();i++){
            profits+=works.get(select.get(i)).profit;
        }

        return profits;
    }

    static boolean check(List<Integer> select){
        for(int i=1;i<select.size();i++){
            if(works.get(select.get(i-1)).end>=works.get(select.get(i)).start) {
                return false;
            }
        }

        for(int i=0;i<select.size();i++){
            if(works.get(select.get(i)).end>n) {
                return false;
            }
        }

        return true;
    }
}
