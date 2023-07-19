package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_18113_그르다김가놈 {
    static int n,k,m;
    static ArrayList<Integer> list;
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());//김밥 개수
        k=Integer.parseInt(st.nextToken());//꼬다리 길이
        m=Integer.parseInt(st.nextToken());//김밥조각의 최소 개수
        list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int input=Integer.parseInt(in.readLine());
            if(input<=k){
                continue;
            }
            else if(input<2*k){
                input-=k;
            }
            else{
                input-=2*k;
            }
            if(input!=0) {
                list.add(input);
            }
        }
        if(list.isEmpty()){
            out.write(String.valueOf(-1));
            out.close();
            in.close();
            System.exit(0);
        }

        /*
        완전 탐색 시 시간 초과 발생
        최대한 가까운 값을 찾아가기 위해 이분탐색
         */
        int start=1, end=1000_000_000;
        res=-1;
        while(start<=end){
            int mid=(start+end)/2;//중간값으로 계산하고
            int cnt=0;
            for(int num:list){
                cnt+=num/mid;
            }
            if(cnt>=m){//김밥조각의 개수가 크다면
                res=mid;
                start=mid+1;//나누는 p가 좀 더 커져도 괜찮음
            }
            else{
                end=mid-1;
            }
        }
        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
