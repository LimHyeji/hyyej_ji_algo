package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class boj_16139_인간컴퓨터상호작용 {
static String input;
static int q;
static int [][] sum;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder str=new StringBuilder();

        input=in.readLine();
        sum=new int[input.length()][26];
        int first_idx=input.charAt(0)-'a';
        sum[0][first_idx]=1;
        for(int i=1;i<input.length();i++){
            int idx=input.charAt(i)-'a';
            sum[i][idx]++;
            for(int j=0;j<26;j++) {
                sum[i][j]+=sum[i-1][j];
            }
        }
//        for(int[] arr:sum){
//            System.out.println(Arrays.toString(arr));
//        }
        q=Integer.parseInt(in.readLine());
        for(int i=0;i<q;i++){
            StringTokenizer st=new StringTokenizer(in.readLine());
            int idx=st.nextToken().charAt(0)-'a';
            int left=Integer.parseInt(st.nextToken());
            int right=Integer.parseInt(st.nextToken());
            if(left==0){
                str.append(sum[right][idx]).append("\n");
            }
            else {
                str.append(sum[right][idx] - sum[left-1][idx]).append("\n");
            }
        }
        out.write(str.toString());
        out.close();
        in.close();
    }
}
