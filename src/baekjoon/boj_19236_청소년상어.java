package baekjoon;

import java.io.*;
import java.util.*;

public class boj_19236_청소년상어 {
    static int[] dirR={-1,-1,0,1,1,1,0,-1};
    static int[] dirC={0,-1,-1,-1,0,1,1,1};
    static int[][] map;
    static class Node{
        int row,col,dir,res;
        Node(int row,int col,int dir,int res){
            this.row=row;
            this.col=col;
            this.dir=dir;
            this.res=res;
        }
    }
    static class Fish{
        int row,col,dir;
        Fish(int row,int col,int dir){
            this.row=row;
            this.col=col;
            this.dir=dir;
        }
    }
    static HashMap<Integer,Fish> fish;
    static Queue<Node> q;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        map=new int[4][4];
        fish=new HashMap<>();
        for(int i=0;i<4;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<4;j++){
                int num=Integer.parseInt(st.nextToken());
                int dir=Integer.parseInt(st.nextToken())-1;
                fish.put(num,new Fish(i,j,dir));
                map[i][j]=num;
            }
        }

        q=new ArrayDeque<>();
        q.add(new Node(0,0,fish.get(map[0][0]).dir,map[0][0]));
        res=map[0][0];

        fish.remove(map[0][0]);
        map[0][0]=-1;

        move();
        hunt();
        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

    static void move(){
        for(int i=1;i<=16;i++){
            System.out.println("I :: "+i);

            if(fish.get(i)==null) continue;

            int curRow=fish.get(i).row;
            int curCol=fish.get(i).col;
            int curDir=fish.get(i).dir;
            System.out.println("DIRECTION :: "+curDir);

            int cnt=0;
            for(int dir=curDir;dir<8;dir++){
                cnt++;
                if(cnt>8) break;

                if(dir==7) dir%=8;

                int newRow=dirR[dir]+curRow;
                int newCol=dirC[dir]+curCol;

                if(newRow<0||newRow>=4||newCol<0||newCol>=4||map[newRow][newCol]==-1) continue;
                System.out.println("NEW :: "+dir);

                int newDir=fish.get(map[newRow][newCol]).dir;

                if(map[newRow][newCol]>0){
                    fish.put(i,new Fish(newRow,newCol,newDir));
                    fish.put(map[newRow][newCol],new Fish(curRow,curCol,curDir));
                    map[curRow][curCol]=map[newRow][newCol];
                    map[newRow][newCol]=i;

                    break;
                }
                else{
                    fish.put(i,new Fish(newRow,newCol,newDir));
                    map[curRow][curCol]=0;
                    map[newRow][newCol]=i;
                    break;
                }
            }

            print();
        }
    }

    static void hunt(){
        Queue<Node> q=new ArrayDeque<>();

        while(!q.isEmpty()){
            Node cur=q.poll();

            int curRow=cur.row;
            int curCol=cur.col;
            int curDir=cur.dir;
            int curRes=cur.res;

            res=Math.max(curRes,res);

            int newR=dirR[curDir]+curRow;
            int newC=dirC[curDir]+curCol;

            if(newR<0||newR>=4||newC<0||newC>=4||map[newR][newC]<=0) continue;

            int newDir=fish.get(map[newR][newC]).dir;

            q.add(new Node(newR,newC,newDir,curRes+map[newR][newC]));

            fish.remove(map[newR][newC]);
            map[newR][newC]=-1;

        }
    }

    static void print()
    {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
