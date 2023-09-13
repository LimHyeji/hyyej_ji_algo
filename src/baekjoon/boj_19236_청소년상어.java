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
    static int res;
    static int cnt;

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

        int temp=map[0][0];
        res=temp;

        int tempDir=fish.get(map[0][0]).dir;

        fish.remove(map[0][0]);
        map[0][0]=-1;

        cnt=0;
        while(cnt<50) {
            move();
            dfs(new Node(0, 0, tempDir, temp), map);
            check();
            print(map);
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();

    }

    static void move(){
        for(int i=1;i<=16;i++){
            if(fish.get(i)==null) continue;

            int curRow=fish.get(i).row;
            int curCol=fish.get(i).col;
            int curDir=fish.get(i).dir;

            int dir=curDir;
            for(int j=0;j<8;j++, dir++, dir%=8){

                int newRow=dirR[dir]+curRow;
                int newCol=dirC[dir]+curCol;

                if(newRow<0||newRow>=4||newCol<0||newCol>=4||map[newRow][newCol]==-1) continue;

                int newDir=fish.get(map[newRow][newCol]).dir;

                if(map[newRow][newCol]>0){
                    fish.put(i,new Fish(newRow,newCol,curDir));
                    fish.put(map[newRow][newCol],new Fish(curRow,curCol,newDir));
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
        }
    }

    static void dfs(Node cur,int[][] tmpMap) {
        cnt++;
        int curRow = cur.row;
        int curCol = cur.col;
        int curDir = cur.dir;
        int curRes = cur.res;

        if(res<curRes){
            map=tmpMap;
            res=curRes;
        }

        for (int i = 1; i <= 3; i++) {
            int newR = dirR[curDir] * i + curRow;
            int newC = dirC[curDir] * i + curCol;

            if (newR < 0 || newR >= 4 || newC < 0 || newC >= 4 || tmpMap[newR][newC] <= 0) continue;

            int newDir = fish.get(tmpMap[newR][newC]).dir;

            int temp = tmpMap[newR][newC];
            int[][] copy=tmpMap;
            copy[newR][newC] = -1;
            dfs(new Node(newR, newC, newDir, curRes + temp), copy);
        }

    }

    static void print(int[][] map)
    {
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void check(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(map[i][j]==-1&&fish.get(map[i][j])!=null){
                    fish.remove(map[i][j]);
                }
            }
        }
    }
}
