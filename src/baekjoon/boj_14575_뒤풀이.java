package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_14575_뒤풀이 {
    /*
    L 이상 R 이하 필요
    전체 T
    각 S 이하
     */
    static int n,t;
    static class Person{
        int l,r;
        Person(int l,int r){
            this.l=l;
            this.r=r;
        }
    }
    static Person[] people;
    static int min,max;
    static int l_max;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());
        people=new Person[n];
        min=0;max=0;l_max=0;
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            people[i]=new Person(l,r);
            min+=l;
            max+=r;

            l_max=Math.max(l_max,l);
        }

        res=0;
        if(t>=min&&t<=max){
            //
        }
        else{
            res=-1;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
