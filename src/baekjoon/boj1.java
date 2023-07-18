package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1 {
    static int w, h;
    static int[] dirR = { 1, 0 };
    static int[] dirC = { 0, 1 };

    static class Node {
        int row, col, dir, move;

        Node(int row, int col, int dir, int move) {
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.move = move;
        }

        @Override
        public String toString() {
            return "Node [row=" + row + ", col=" + col + ", dir=" + dir + ", move=" + move + "]";
        }

    }

    static int res;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        res = 0;
        sol();
        System.out.println(res%100000);
    }

    static void sol() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0, 0));
        q.add(new Node(0, 0, 1, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            System.out.println(cur.toString());
            if (cur.row == h - 1 && cur.col == w - 1) {
                res++;
                continue;
            }

            for (int d = 0; d < 2; d++) {
                int newR = cur.row + dirR[d];
                int newC = cur.col + dirC[d];

                if (newR < 0 || newR >= h || newC < 0 || newC >= w) {
                    continue;
                }
                if (newR == 0 || newC == 0) {
                    q.add(new Node(newR, newC, d, cur.move));
                } else {
                    if (cur.dir != d) {
                        if (cur.move <= 1) {
                            continue;
                        } else {
                            q.add(new Node(newR, newC, d, 0));
                        }
                    } else {
                        q.add(new Node(newR, newC, d, cur.move + 1));
                    }
                }
            }
        }

    }
}
