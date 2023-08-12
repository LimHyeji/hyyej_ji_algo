package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_8983_사냥꾼 {
    static int m,n,l;
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
        }
    }
    static ArrayList<Node> animal;
    static ArrayList<Integer> hunter;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        l=Integer.parseInt(st.nextToken());

        hunter=new ArrayList<>();
        st=new StringTokenizer(in.readLine());
        for(int i=0;i<m;i++){
            hunter.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(hunter);

        animal=new ArrayList<>();
        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            //if(b>l) continue;

            animal.add(new Node(a,b));
        }

        int res=0;
        for(int i=0;i<animal.size();i++){
            res+=search(animal.get(i).row,animal.get(i).col);
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static int search(int row,int col){
        int start=0;
        int end=m;
        int mid=0;
        while(start<=end){
            mid=(start+end)/2;
            if(mid>=m) return 0;

            int distance=Math.abs(row-hunter.get(mid))+col;

            if(l<distance&&row<hunter.get(mid)) end=mid-1;
            else if(l<distance&&row>=hunter.get(mid)) start=mid+1;
            else if(l>=distance) return 1;
        }
        return 0;
    }
}
