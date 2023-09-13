package baekjoon;

import java.io.*;
import java.util.*;

public class boj_19236_청소년상어 {
    static int[] dirR={-1,-1,0,1,1,1,0,-1};
    static int[] dirC={0,-1,-1,-1,0,1,1,1};
    static int[][] map;

    static class Shark{
        int row,col,dir,eat;
        Shark(int row,int col,int dir,int eat){
            this.row=row;
            this.col=col;
            this.dir=dir;
            this.eat=eat;
        }
    }

    static class Fish{
        int row,col,dir;
        boolean dead;
        Fish(int row,int col,int dir,boolean dead){
            this.row=row;
            this.col=col;
            this.dir=dir;
            this.dead=dead;
        }
    }
    static HashMap<Integer,Fish> fish;
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
                fish.put(num,new Fish(i,j,dir,false));
                map[i][j]=num;
            }
        }

        int first=map[0][0];
        Fish firstFish=fish.get(first);
        Shark shark=new Shark(0,0,firstFish.dir,first);

        firstFish.dead=true;
        map[0][0]=-1;
        fish.put(first,firstFish);

        dfs(shark, map, fish);

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }

    static void dfs(Shark cur,int[][] tmpMap, HashMap<Integer,Fish> fish) {
        res=Math.max(res, cur.eat);

        move(tmpMap,fish);

        for (int i = 1; i <= 3; i++) {
            int newR = cur.row+dirR[cur.dir]*i;
            int newC = cur.col+dirC[cur.dir]*i;

            if (newR < 0 || newR >= 4 || newC < 0 || newC >= 4 || tmpMap[newR][newC] <= 0) continue;

            int[][] copyArr=copyArr(tmpMap);
            HashMap<Integer,Fish> copyFish=copyFish(fish);

            int num=copyArr[newR][newC];

            copyArr[cur.row][cur.col]=0;
            copyArr[newR][newC] = -1;

            Fish newFish=copyFish.get(num);
            Shark newShark=new Shark(newFish.row,newFish.col,newFish.dir,cur.eat+num);

            newFish.dead=true;
            copyFish.put(num,newFish);

            dfs(newShark, copyArr, copyFish);
        }
    }

    static void move(int[][] map, HashMap<Integer,Fish> fish){
        for(int i=1;i<=16;i++){
            if(fish.get(i).dead) continue;

            int curR=fish.get(i).row;
            int curC=fish.get(i).col;
            int curD=fish.get(i).dir;

            int dir=curD;
            for(int j=0;j<8;j++, dir++, dir%=8){

                int newR=dirR[dir]+curR;
                int newC=dirC[dir]+curC;

                if(newR<0||newR>=4||newC<0||newC>=4||map[newR][newC]==-1) continue;

                if(map[newR][newC]>0){
                    int tempNum=map[newR][newC];
                    Fish temp=fish.get(tempNum);
                    temp.row=curR;
                    temp.col=curC;
                    map[curR][curC]=tempNum;

                    fish.put(i,new Fish(newR,newC,dir,false));
                    fish.put(tempNum,temp);

                    map[newR][newC]=i;

                    break;
                }
                else{
                    fish.put(i,new Fish(newR,newC,dir,false));
                    map[curR][curC]=0;
                    map[newR][newC]=i;
                    break;
                }
            }
        }
    }

    static int[][] copyArr(int[][] map) {
        int[][] copy=new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                copy[i][j]=map[i][j];
            }
        }
        return copy;
    }

    static HashMap<Integer,Fish> copyFish(HashMap<Integer,Fish> fish){
        HashMap<Integer,Fish> copy=new HashMap<>();
        for(int i=1;i<=16;i++){
            copy.put(i,fish.get(i));
        }
        return copy;
    }
}
