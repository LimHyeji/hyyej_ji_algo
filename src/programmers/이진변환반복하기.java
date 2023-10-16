package programmers;

public class 이진변환반복하기 {
    class Solution {
        public int[] solution(String s) {
            int cnt=0,zero_cnt=0;
            while(!s.equals("1")){
                cnt++;
                int one_cnt=0;
                for(int i=0;i<s.length();i++){
                    if(s.charAt(i)=='1') one_cnt++;
                    else zero_cnt++;
                }

                StringBuilder str=new StringBuilder();
                while(one_cnt>0){
                    str.append(one_cnt%2);
                    one_cnt/=2;
                }
                s=str.reverse().toString();
            }


            return new int[] {cnt,zero_cnt};
        }
    }
}
