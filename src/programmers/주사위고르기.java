package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 주사위고르기 {

    class Solution {
        static int n, max;
        static int[] num;
        static boolean[] sel;

        static int[][] map;
        static List<Integer> scoreA, scoreB;

        static int[] answer;

        public int[] solution(int[][] dice) {
            n = dice.length;
            max = 0;
            answer = new int[n / 2];

            num = new int[n / 2];
            sel = new boolean[n];
            map = dice;
            com(0, 0);

            return answer;
        }

        public void getScore(int[] arr, List<Integer> score, int sum, int cnt) {
            if (cnt == n / 2) {
                score.add(sum);
                return;
            }

            for (int i = 0; i < 6; i++) {
                getScore(arr, score, sum + map[arr[cnt]][i], cnt + 1);
            }
        }

        public void calculate(int[] a, int[] b) {

            int count = 0;

            scoreA = new ArrayList<>();
            scoreB = new ArrayList<>();

            getScore(a, scoreA, 0, 0);
            getScore(b, scoreB, 0, 0);

            Collections.sort(scoreA);
            Collections.sort(scoreB);

            for (int score : scoreA) {
                int left = 0;
                int right = scoreB.size() - 1;

                while (left <= right) {
                    int mid = (left + right) / 2;

                    if (score > scoreB.get(mid)) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                count += left;
            }

            if (count > max) {
                max = count;
                int idx = 0;
                for (int i = 0; i < a.length; i++) {
                    answer[idx++] = a[i] + 1;
                }
            }

        }

        public void com(int start, int cnt) {
            if (cnt == n / 2) {
                int[] temp = new int[n / 2];
                int idx = 0;

                for (int i = 0; i < n; i++) {
                    if (!sel[i]) temp[idx++] = i;
                }

                calculate(num, temp);
                return;
            }

            for (int i = start; i < n; i++) {
                sel[i] = true;
                num[cnt] = i;
                com(i + 1, cnt + 1);
                sel[i] = false;
            }
        }
    }
}
