package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_5427_불 {
    static int t, w, h;

    static class Node {
        int row, col;
        int cost;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        Node(int row, int col, int cost) {
            this.row = row;
            this.col = col;
            this.cost = cost;
        }
    }

    static char[][] map;
    static Queue<Node> person;
    static Queue<Node> fire;
    static int[] dirR = { -1, 1, 0, 0 };
    static int[] dirC = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= t; test_case++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            person = new LinkedList<>();
            fire = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                String input = in.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = input.charAt(j);
                    if (map[i][j] == '@') {
                        person.add(new Node(i, j, 0));
                    }
                    if (map[i][j] == '*') {
                        fire.add(new Node(i, j));
                    }
                }
            }

            System.out.println(solution());
        }
    }

    static String solution() {

        while (!person.isEmpty()) {
            fire();

            int size=person.size();
            for (int i = 0; i < size; i++) {
                Node cur = person.poll();

                if (cur.row == h - 1 || cur.row == 0 || cur.col == w - 1 || cur.col == 0) {
                    return Integer.toString(cur.cost + 1);
                }

                for (int dir = 0; dir < 4; dir++) {
                    int newR = cur.row + dirR[dir];
                    int newC = cur.col + dirC[dir];

                    if (newR >= 0 && newR < h && newC >= 0 && newC < w) {
                        if (map[newR][newC] == '.') {
                            map[newR][newC] = '@';
                            person.add(new Node(newR, newC, cur.cost + 1));
                        }
                    }
                }
            }
        }

        return "IMPOSSIBLE";
    }

    static void fire() {
        int size=fire.size();
        for (int i = 0; i < size; i++) {
            Node cur = fire.poll();

            for (int dir = 0; dir < 4; dir++) {
                int newR = cur.row + dirR[dir];
                int newC = cur.col + dirC[dir];

                if (newR < 0 || newR >= h || newC < 0 || newC >= w) {
                    continue;
                }
                if (map[newR][newC] == '.' || map[newR][newC] == '@') {
                    map[newR][newC] = '*';
                    fire.add(new Node(newR, newC));
                }
            }
        }
    }
}
