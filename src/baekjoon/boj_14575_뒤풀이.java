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
        int left,right;
        Person(int left,int right){
            this.left=left;
            this.right=right;
        }
    }
    static Person[] people;
    static int min_sum,max_sum;
    static int l_max,r_max;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());


        min_sum=0;max_sum=0;l_max=0;r_max=0;
        people=new Person[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int l=Integer.parseInt(st.nextToken());
            int r=Integer.parseInt(st.nextToken());
            people[i]=new Person(l,r);

            min_sum+=l;
            max_sum+=r;

            l_max=Math.max(l_max,l);
            r_max=Math.max(r_max,r);
        }

        res=0;
        if(t<min_sum||t>max_sum){
            res=-1;
        }
        else if(t==min_sum){
            res=l_max;
        }
        else if(t==max_sum){
            res=r_max;
        }
        else{
            int left=l_max;
            int right=r_max;
            int mid=(left+right)/2;
            while(left<=right){
                mid=(left+right)/2;
                for(Person p:people){
                    if(mid<p.left){
                        left=mid+1;
                        break;
                    }
                    else if(mid>p.right){
                        right=mid-1;
                        break;
                    }
                }
//                System.out.println("LEFT: "+left);
//                System.out.println("MID: "+mid);
//                System.out.println("RIGHT: "+right);
            }
            res=mid;
        }


        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
