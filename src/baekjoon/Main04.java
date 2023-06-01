package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main04 {
    static int n, m, k;
    static int[] dirR = { -1, 1, 0, 0 };
    static int[] dirC = { 0, 0, -1, 1 };
    static char[][] board;
    static int[][][] visit;
    static String word;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String input = in.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        word = in.readLine();
        visit = new int[n][m][word.length()];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(visit[i][j], -1);
            }
        }

        res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    res += sol(0, i, j);
                }
            }
        }
        System.out.println(res);

    }

    static int sol(int idx, int row, int col) {
        if (visit[row][col][idx] != -1)
            return visit[row][col][idx];
        if (idx == word.length() - 1) {
            visit[row][col][idx] = 1;
            return 1;
        }

        visit[row][col][idx] = 0;
        for (int dir = 0; dir < 4; dir++) {
            for (int i = 1; i <= k; i++) {
                int newR = row + dirR[dir] * i;
                int newC = col + dirC[dir] * i;
                if (newR < 0 || newR >= n || newC < 0 || newC >= m)
                    continue;
                if (board[newR][newC] == word.charAt(idx + 1)) {
                    visit[row][col][idx] += sol(idx + 1, newR, newC);
                }
            }
        }
        return visit[row][col][idx];
    }
}
