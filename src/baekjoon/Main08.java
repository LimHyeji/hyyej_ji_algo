package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main08 {
    static int n;//수열 사이즈
    static long[] arr;//수열
    static boolean[] visit;//방문 배열
    static long res;//결과

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(in.readLine());
        st = new StringTokenizer(in.readLine());

        arr = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //입력 끝

        long left = 1;
        long right = cal(1, n);
        long mid = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            visit = new boolean[n + 1];
            visit[1] = true;

            for (int i = 2; i < n + 1; i++) {
                for (int j = 1; j < i; j++) {
                    long temp = cal(j, i);
                    if (visit[j] && temp <= mid) {
                        visit[i] = true;
                        break;
                    }
                }
            }
            if (visit[n]) {
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(res);
    }

    static long cal(int i, int j) {//힘 계산 메소드
        return (j - i) * (1 + Math.abs(arr[i] - arr[j]));
    }
}
