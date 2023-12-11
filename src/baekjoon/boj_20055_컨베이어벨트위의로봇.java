package baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_20055_컨베이어벨트위의로봇 {
    static int n,k,time;

    static class Block{
        int limit;
        boolean robot;

        Block(int limit,boolean robot){
            this.limit=limit;
            this.robot=robot;
        }
    }
    static ArrayDeque<Block> belt;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());

        belt=new ArrayDeque<>();

        st=new StringTokenizer(in.readLine());
        for(int i=0;i<2*n;i++){
            belt.add(new Block(Integer.parseInt(st.nextToken()),false));
        }

        /*
        1. 벨트 한 칸 회전
        2. 가장 먼저 올라간 로봇부터 회전 방향으로 한칸 이동 가능(로봇이 없고, 내구도 1 이상)하면 이동
        3. 올리는 위치의 칸 내구도가 0이 아니면 로봇 올림
        - 내구도 0인 칸 개수가 K 이상일 때 종료
         */

        time=0;
        while(checkPossible()){
            round1();
//            for(Block b: belt){
//                System.out.print((b.robot?"O ":"X "));
//            }
//            System.out.println();
            round2();
//            for(Block b: belt){
//                System.out.print((b.robot?"O ":"X "));
//            }
//            System.out.println();
            round3();
//            for(Block b: belt){
//                System.out.print((b.robot?"O ":"X "));
//            }
//            System.out.println();
//            System.out.println();

            time++;
        }

        System.out.println(time);
    }

    static boolean checkPossible(){
        int count=0;
        for(Block block:belt){
            if(block.limit==0) count++;
        }

        if(count>=k) return false;
        return true;
    }

    static void move(){
        Block tail=belt.removeLast();
        belt.addFirst(tail);
    }

    static void round1(){
        for(int i=0;i<n;i++){
            move();
        }

        Block nthBlock=belt.removeLast();
        if(nthBlock.robot) nthBlock.robot=false;
        belt.addFirst(nthBlock);

        for(int i=0;i<n;i++){
            move();
        }
    }

    static void round2(){
        for(int i=0;i<n;i++) {
            move(); //n+1부터 2n까지의 로봇은 한칸씩 이동할 필요 없다
        }

        //n번째는 로봇 내리기
        Block next=belt.removeLast();
        next.robot=false;
        for(int i=0;i<n-1;i++){
            Block cur=belt.removeLast();
            if(cur.robot){
                if(!next.robot&&next.limit>0){
                    next.robot=true;
                    next.limit--;
                    cur.robot=false;
                }
            }
            belt.addFirst(next);
            next=cur;
        }
        belt.addFirst(next);
    }

    static void round3(){
        Block head=belt.removeFirst();
        if(head.limit!=0) {
            head.robot=true;
            head.limit--;
        }
        belt.addFirst(head);
    }
}
