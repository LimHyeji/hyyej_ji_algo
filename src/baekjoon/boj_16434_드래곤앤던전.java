package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_16434_드래곤앤던전 {
    static int n;
    static long atk;
    static class Room{
        int type;
        long atk;
        long hp;
        Room(int type,long atk,long hp){
            this.type=type;
            this.atk=atk;
            this.hp=hp;
        }
    }
    static ArrayList<Room> list;
    static long max_hp;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        atk=Long.parseLong(st.nextToken());

        list=new ArrayList<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            int type=Integer.parseInt(st.nextToken());
            long atk=Long.parseLong(st.nextToken());
            long hp=Long.parseLong(st.nextToken());
            list.add(new Room(type,atk,hp));
        }

        long hp=0;
        for(int i=0;i<n;i++){
            if(list.get(i).type==1){//몬스터
                long q=list.get(i).hp/atk;
                long r=list.get(i).hp%atk;

                if(r==0) {
                    q--;
                }
                hp-=q*list.get(i).atk;

//                System.out.println("몬스터 공격력 "+list.get(i).atk);
//                System.out.println("몬스터 hp "+list.get(i).hp);
//                System.out.println("용사 공격력 "+atk);
 //               System.out.println("몬스터 후 "+hp);
            }
            else{//포션
                hp+=list.get(i).hp;
                atk+=list.get(i).atk;

                if(hp>0)
                    hp=0;

//                System.out.println("포션 공격력 추가 "+list.get(i).atk);
//                System.out.println("포션 hp 추가 "+list.get(i).hp);
//                System.out.println("용사 공격력 "+atk);
//                System.out.println("포션 후 "+hp);
            }
            max_hp=Math.min(max_hp,hp);
        }
        max_hp--;
        out.write(String.valueOf(Math.abs(max_hp)));
        out.close();
        in.close();

    }
}
