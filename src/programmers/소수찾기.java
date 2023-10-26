package programmers;

import java.util.HashSet;

public class 소수찾기 {

    class Solution {
        int answer=0;
        int[] arr;
        HashSet<Long> visit=new HashSet<>();

        public int solution(String numbers) {
            arr=new int[numbers.length()];
            for(int i=0;i<numbers.length();i++){
                arr[i]=numbers.charAt(i)-'0';
            }

            for(int i=0;i<numbers.length();i++){
                num=new int[i+1];
                sel=new boolean[arr.length];
                per(0,i+1);
            }

            return answer;
        }

        int[] num;
        boolean[] sel;
        public void per(int cnt, int end){
            if(cnt==end){
                StringBuilder str=new StringBuilder();
                for(int i=0;i<num.length;i++){
                    str.append(num[i]);
                }
                long n=Long.parseLong(str.toString());
                boolean p=true;
                if(n<2) {
                    p=false;
                    return;
                }
                for(long i=2;i<=Math.sqrt(n);i++){
                    if(n%i==0) {
                        p=false;
                        break;
                    }
                }
                if(p&&!visit.contains(n)){
                    answer++;

                    visit.add(n);
                }
                return;
            }

            for(int i=0;i<arr.length;i++){
                if(sel[i]) continue;
                num[cnt]=arr[i];
                sel[i]=true;

                per(cnt+1,end);

                sel[i]=false;
            }
        }
    }
}
