package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1062_가르침 {
    static int n,k;
    static String[] list;
    static boolean[] sel;
    static int res=0;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        list=new String[n];
        for(int i=0;i<n;i++){
            String word=in.readLine();
            list[i]=word.substring(4,word.length()-4);
        }

        if(k<5||k==26){
            res=k<5?0:n;
        }
        else{
            sel=new boolean[26];
            sel['a'-'a']=true;
            sel['n'-'a']=true;
            sel['t'-'a']=true;
            sel['i'-'a']=true;
            sel['c'-'a']=true;

            sol(0,0);
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

    public static void sol(int idx,int cnt){
        if(cnt==k-5){
            int count=0;
            for(int i=0;i<n;i++){
                boolean read= true;
                for(int j=0;j<list[i].length();j++){
                    if(!sel[list[i].charAt(j)-'a']){
                        read=false;
                        break;
                    }
                }
                if(read) count++;
            }
            res=Math.max(res,count);
            return;
        }

        for(int i=idx;i<26;i++){
            if(!sel[i]){
                sel[i]=true;
                sol(i+1,cnt+1);
                sel[i]=false;
            }
        }
    }
}
