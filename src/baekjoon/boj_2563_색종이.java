package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_2563_색종이 {
    static int n;
    static int[][] board;
    static int res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;

        n = Integer.parseInt(in.readLine());
        board = new int[101][101];

        for (int i = 0; i < n; i++) {
            st=new StringTokenizer(in.readLine());

            int col1 = Integer.parseInt(st.nextToken());
            int col2 = col1 + 10;
            int row2 = Integer.parseInt(st.nextToken());
            int row1 = row2 + 10;

            board[row1][col1] += 1;//왼쪽위 위치에 1 더하기
            board[row1][col2] -= 1;//오른쪽위 위치에 1 빼기
            board[row2][col1] -= 1;//왼쪽아래 위치에 1 빼기
            board[row2][col2] += 1;//오른쪽 아래 위치에 1 더하기
        }

        res = 0;
        for (int row = 1; row < 101; row++) {
            for (int col = 1; col < 101; col++) {
                board[row][col] += board[row][col - 1];//합을 오른쪽으로 누적
            }
        }

        for (int col = 1; col < 101; col++) {
            for (int row = 1; row < 101; row++) {
                board[row][col] += board[row - 1][col];//합을 아래쪽으로 누적
                if (board[row][col] != 0) {
                    res++;
                }
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
