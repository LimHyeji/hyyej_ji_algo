package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class boj_2448_별찍기11
{
    static int n;
    static char[][] map;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();

        map=new char[n][2*n-1];
        for(int i=0;i<n;i++){
            Arrays.fill(map[i],' ');
        }
        sol(0,n-1,n);
        for(char[] arr:map){
            System.out.println(arr);
        }
    }

    public static void sol(int row,int col,int n){
        if(n==3){
            map[row][col]='*';
            map[row+1][col-1]=map[row+1][col+1]='*';
            map[row+2][col-2]=map[row+2][col-1]=map[row+2][col]=map[row+2][col+1]=map[row+2][col+2]='*';
            return;
        }

        sol(row,col,n/2);
        sol(row+n/2,col-n/2,n/2);
        sol(row+n/2,col+n/2,n/2);
    }
}