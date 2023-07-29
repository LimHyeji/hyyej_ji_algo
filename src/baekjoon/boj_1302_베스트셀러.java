package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class boj_1302_베스트셀러 {
    static int n;
    static HashSet<String> books;
    static class Book implements Comparable<Book>{
        String title;
        int cnt;
        Book(String title){
            this.title=title;
            this.cnt=1;
        }

        @Override
        public int compareTo(Book o) {
            int length= Math.min(this.title.length(),o.title.length());
            if(this.cnt<o.cnt){
                return 1;
            }
            else if(this.cnt>o.cnt){
                return -1;
            }
            else {
                for (int i = 0; i < length; i++) {
                    if (this.title.charAt(i) < o.title.charAt(i)) {
                        return -1;
                    }
                    else if(this.title.charAt(i)==o.title.charAt(i)){
                        continue;
                    }
                    else{
                        return 1;
                    }
                }
            }
            if(this.title.length()<o.title.length()){
                return -1;
            }
            return 1;
        }
    }
    static ArrayList<Book> list;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        n=Integer.parseInt(in.readLine());
        books=new HashSet<>();
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            String input=in.readLine();
            if(!books.contains(input)){
                books.add(input);
                list.add(new Book(input));
            }
            else{
                for(int j=0;j<list.size();j++){
                    if(list.get(j).title.equals(input)){
                        list.get(j).cnt++;
                    }
                }
            }
        }

//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).title+" , "+list.get(i).cnt);
//        }

        Collections.sort(list);
//
//        for(int i=0;i<list.size();i++){
//            System.out.println(list.get(i).title+" , "+list.get(i).cnt);
//        }

        out.write(list.get(0).title);
        out.close();
        in.close();
    }


}
