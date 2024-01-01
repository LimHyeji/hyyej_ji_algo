package baekjoon;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class boj_17255_N으로만들기 {
    static char[] arr;
    static Set<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        arr=in.readLine().toCharArray();
        set=new HashSet<>();

        for(int i=0;i<arr.length;i++){
            sol(i,i,arr[i]+"",arr[i]+"");
        }

        out.write(String.valueOf(set.size()));
        out.close();
        in.close();
    }

    public static void sol(int left,int right,String word,String path){
        if(left==0&&right==arr.length-1) {
            set.add(path);
            return;
        }

        if(left>=1) sol(left-1,right,arr[left-1]+word,path+" "+arr[left-1]+word);
        if(right<=arr.length-2) sol(left,right+1,word+arr[right+1],path+" "+word+arr[right+1]);
    }
}
