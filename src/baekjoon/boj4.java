package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj4 {
    static int n;
    static char[][] map;

    static class Node {
        int row, col;
        int cnt;
        int horizon = -1;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Node(int row, int col, int cnt, int horizon) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.horizon = horizon;
        }
    }

    static Node B;
    static Node E;
    static int[][][] visit;
    static int[] dirR = { -1, 1, 0, 0 };
    static int[] dirC = { 0, 0, -1, 1 };
    static int res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            // map[i]=in.readLine().toCharArray();
            String input = in.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'B') {
                    if (B == null) {
                        B = new Node(i, j);
                    } else {
                        if (B.horizon == -1) {
                            if (B.row != i) {
                                B = new Node(i, j, 0, 0);
                            } else {
                                B = new Node(i, j, 0, 1);
                            }
                        }
                    }
                    map[i][j] = '0';
                }
                if (map[i][j] == 'E') {
                    if (E == null) {
                        E = new Node(i, j);
                    } else {
                        if (E.horizon == -1) {
                            if (E.row != i) {
                                E = new Node(i, j, 0, 0);
                            } else {
                                E = new Node(i, j, 0, 1);
                            }
                        }
                    }
                }
            }
        }
        visit = new int[n][n][2];
        res = Integer.MAX_VALUE;
        System.out.println(sol());
    }

    static int sol() {
        Queue<Node> q = new LinkedList<>();

        q.add(B);
        visit[B.row][B.col][B.horizon] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.row == E.row && cur.col == E.col && cur.horizon == E.horizon) {
                return cur.cnt;
            }

            for (int dir = 0; dir < 4; dir++) {
                if (cur.horizon == 1) {
                    if (dir == 0 || dir == 1) {// 수평이 위 아래로 3칸 확인
                        int newR = cur.row + dirR[dir];
                        int newC = cur.col;

                        if (check(newR, newC) || visit[newR][newC][cur.horizon] == 1 || check(newR, newC - 1)
                                || check(newR, newC + 1)) {
                            continue;
                        }

                        q.add(new Node(newR, newC, cur.cnt + 1, cur.horizon));
                        visit[newR][newC][cur.horizon] = 1;
                    } else {// 수평이 왼왼 오오 1칸 확인
                        int newR = cur.row;
                        int newC = cur.col + dirC[dir] * 2;
                        if (check(newR, newC) || visit[newR][newC - dirC[dir]][cur.horizon] == 1) {
                            continue;
                        }
                        q.add(new Node(newR, newC - dirC[dir], cur.cnt + 1, cur.horizon));
                        visit[newR][newC - dirC[dir]][cur.horizon] = 1;
                    }
                } else {
                    if (dir == 2 || dir == 3) {// 수직이 왼 오로 3칸 확인
                        int newR = cur.row;
                        int newC = cur.col + dirC[dir];

                        if (check(newR, newC) || visit[newR][newC][cur.horizon] == 1 || check(newR - 1, newC)
                                || check(newR + 1, newC)) {
                            continue;
                        }

                        q.add(new Node(newR, newC, cur.cnt + 1, cur.horizon));
                        visit[newR][newC][cur.horizon] = 1;
                    } else {// 수직이 위위 아아 1칸 확인
                        int newR = cur.row + dirR[dir] * 2;
                        int newC = cur.col;
                        if (check(newR, newC) || visit[newR - dirR[dir]][newC][cur.horizon] == 1) {
                            continue;
                        }

                        q.add(new Node(newR - dirR[dir], newC, cur.cnt + 1, cur.horizon));
                        visit[newR - dirR[dir]][newC][cur.horizon] = 1;

                    }
                }
            }

            if (visit[cur.row][cur.col][cur.horizon == 0 ? 1 : 0] == 1) {
                continue;
            }

            boolean flag = true;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newR = cur.row + i;
                    int newC = cur.col + j;
                    if (check(newR, newC)) {
                        flag = false;
                        break;
                    }
                }
                if (flag == false) {
                    break;
                }
            }
            if (flag == true) {
                q.add(new Node(cur.row, cur.col, cur.cnt + 1, cur.horizon == 0 ? 1 : 0));
                visit[cur.row][cur.col][cur.horizon == 0 ? 1 : 0] = 1;
            }

        }
        return 0;
    }

    static boolean check(int newR, int newC) {
        if (newR < 0 || newR >= n || newC < 0 || newC >= n || map[newR][newC] == '1') {
            return true;
        }
        return false;
    }
}
