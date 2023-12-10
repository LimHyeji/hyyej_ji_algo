package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2156_포도주시식 {
    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        init();
        System.out.println(calculate());

    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp=new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

    }

    private static int calculate(){

        if ( n == 1) {
            return arr[1];
        }

        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] + arr[i - 1]+ arr[i], Math.max(dp[i - 2]+arr[i], dp[i - 1]));
        }

        return Arrays.stream(dp).max().orElseThrow();
    }
}
