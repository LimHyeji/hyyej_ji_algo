package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16926_배열돌리기1 {
    static int n,m,r;
    static int[][] arr;
    static StringBuilder str;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < Math.min(n, m) / 2; j++) {
                int temp = arr[j][j];
                for (int k = j + 1; k < m - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }
                for (int k = j + 1; k < n - j; k++) {
                    arr[k - 1][m - j - 1] = arr[k][m - j - 1];
                }
                for (int k = m - j - 2; k >= j; k--) {
                    arr[n - j - 1][k + 1] = arr[n - j - 1][k];
                }
                for (int k = n - j - 2; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }

        str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                str.append(arr[i][j]).append(" ");
            }
            str.append("\n");
        }

        out.write(str.toString());
        out.close();
        in.close();
    }
}
