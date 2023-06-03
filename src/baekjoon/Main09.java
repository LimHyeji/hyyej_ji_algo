package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main09 {
    static int n;//
    static int res;//

    static class Student {
        int row, col;
        int[] like;

        Student(int[] like) {
            this.like = like;
        }

        public void seat(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static Student[] s;//
    static int[] order;//
    static boolean[] seat;//
    static int[][] room;//

    static class Condition implements Comparable<Condition> {
        int row, col;
        int likec, emptyc;

        Condition(int row, int col, int likec, int emptyc) {
            this.row = row;
            this.col = col;
            this.likec = likec;
            this.emptyc = emptyc;
        }

        @Override
        public int compareTo(Condition o) {
            if (this.likec > o.likec) {
                return -1;
            } else if (this.likec == o.likec) {
                if (this.emptyc > o.emptyc) {
                    return -1;
                } else if (this.emptyc == o.emptyc) {
                    if (this.row < o.row) {
                        return -1;
                    } else if (this.row == o.row) {
                        if (this.col < o.col) {
                            return -1;
                        } else if (this.col == o.col) {
                            return 0;
                        }
                    }
                }
            }
            return 1;
        }
    }

    static int[] dirR = { -1, 1, 0, 0 };
    static int[] dirC = { 0, 0, -1, 1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());
        s = new Student[n * n+1];
        order = new int[n * n+1];
        for (int i = 1; i <= n * n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] l = new int[4];
            l[0] = Integer.parseInt(st.nextToken());
            l[1] = Integer.parseInt(st.nextToken());
            l[2] = Integer.parseInt(st.nextToken());
            l[3] = Integer.parseInt(st.nextToken());
            s[num] = new Student(l);
            order[i] = num;
        }

        seat = new boolean[n * n+1];
        room = new int[n][n];
        for (int turn = 1; turn <= n * n; turn++) {
            int num = order[turn];// 지금 앉혀야 하는 사람
            PriorityQueue<Condition> pq = new PriorityQueue<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (room[i][j] == 0) {
                        int likec = 0, emptyc = 0;
                        for (int dir = 0; dir < 4; dir++) {
                            int newR = i + dirR[dir];
                            int newC = j + dirC[dir];
                            if (newR < 0 || newR >= n || newC < 0 || newC >= n) {
                                continue;
                            }
                            if (room[newR][newC] == 0) {
                                emptyc++;
                            }
                            if (room[newR][newC] > 0) {
                                for (int l = 0; l < 4; l++) {
                                    if (s[num].like[l] == room[newR][newC]) {
                                        likec++;
                                    }
                                }
                            }
                        }
                        pq.add(new Condition(i, j, likec, emptyc));
                    }
                }
            }
            // System.out.println(num+ " : "+pq.peek().row+" "+pq.peek().col+" "+pq.peek().likec+" "+pq.peek().emptyc);
            // System.out.println();

            Condition c = pq.poll();
            seat[num] = true;
            s[num].seat(c.row, c.col);
            room[c.row][c.col] = num;
        }

        res = 0;
        for (int i = 1; i <= n * n; i++) {
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                if (getD(s[i], s[s[i].like[j]]) == 1) {
                    cnt++;
                }
            }

            if (cnt == 1)
                res += 1;
            else if (cnt == 2)
                res += 10;
            else if (cnt == 3)
                res += 100;
            else if (cnt == 4)
                res += 1000;
        }
        System.out.println(res);
    }

    static int getD(Student s1, Student s2) {
        return Math.abs(s1.row - s2.row) + Math.abs(s1.col - s2.col);
    }

    static void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
    }
}
