package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16971_배열B의값 {
    static int n,m;
    static int[][] arr;
    static int[][] copy;
    static int[] rowSum,colSum;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        arr=new int[n][m];
        rowSum=new int[n];
        colSum=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(in.readLine());
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int rowMinValue = Integer.MAX_VALUE;
        int minValueRow = -1;
        int colMinValue = Integer.MAX_VALUE;
        int minValueCol  = -1;

        int total = calMapB(arr);

        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < n ; ++j){
                rowSum[i] += arr[i][j];
                colSum[j] += arr[i][j];
            }
        }

        for(int i=1;i<n-1;i++){
            int val = rowSum[i];
            val *= 4;
            val -= 2*(arr[i][0] + arr[i][m-1]);

            if(rowMinValue > val){
                rowMinValue = val;
                minValueRow = i;
            }
        }

        for(int i=1;i<m-1;i++){
            int val = colSum[i];
            val *= 4;
            val -= 2*(arr[0][i] + arr[n-1][i]);

            if(colMinValue > val){
                colMinValue = val;
                minValueCol = i;
            }
        }

        if(minValueRow > 0){
            setCopyMap(true, 0, minValueRow);
            total = Math.max(total, calMapB(copy));

            setCopyMap(true, n-1, minValueRow);
            total = Math.max(total, calMapB(copy));
        }

        if(minValueCol > 0){
            setCopyMap(false, 0, minValueCol);
            total = Math.max(total, calMapB(copy));

            setCopyMap(false, m-1, minValueCol);
            total = Math.max(total, calMapB(copy));
        }

        out.write(String.valueOf(total));
        out.close();
        in.close();
    }

    private static int calMapB(int[][] input){
        int res = 0;

        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < m - 1; j++)
                res += input[i][j] + input[i + 1][j] + input[i + 1][j + 1] + input[i][j + 1];

        return res;
    }

    private static void setCopyMap(boolean flag, int idx1, int idx2){
        copy = new int[n][m];
        for(int i = 0 ; i < n ; ++i){
            for(int j = 0 ; j < m ; ++j){
                copy[i][j] = arr[i][j];
            }
        }
        if(flag) {
            for(int i=0;i<m;i++){
                copy[idx1][i] = arr[idx2][i];
                copy[idx2][i] = arr[idx1][i];
            }
        } else {
            for(int i=0;i<n;i++){
                copy[i][idx1] = arr[i][idx2];
                copy[i][idx2] = arr[i][idx1];
            }
        }
    }
}
