package programmers;

public class K진수에서소수개수구하기 {
    class Solution {
        public int solution(int n, int k) {
            int answer = 0;

            String 변환후=null;
            //10진수는 패스하고, 나머지 진수 변환하기
            if(k<10){
                StringBuilder str=new StringBuilder();
                while(n>k){
                    int temp=n%k;
                    str.append(temp);
                    n/=k;
                }
                str.append((n%k));
                변환후=str.reverse().toString();
            }
            else{
                변환후=String.valueOf(n);
            }


            //0으로 잘라서 후보 숫자 고르기
            String[] 후보=변환후.split("0");

            //후보 숫자 중 소수인지 계산하기
            int size=후보.length;
            for(int i=0;i<size;i++){
                if(후보[i].equals("")) continue;
                long 후보숫자=Long.parseLong(후보[i]);
                if(후보숫자<2) continue;

                if(check(후보숫자)){
                    answer++;
                }
            }

            return answer;
        }

        public boolean check(long num){
            long 절반=(long)Math.sqrt(num)+1;
            for(long i=2;i<절반;i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }
}
