package programmers;

public class 나라의숫자 {
    class Solution {
        StringBuilder str=new StringBuilder();
        public String solution(int n) {

            while(n>0){
                int remain=n%3;
                add(remain);
                n/=3;

                if(remain==0) n--;
            }

            return str.reverse().toString();
        }
        void add(int n){
            if(n==1){
                str.append(1);
            }
            else if(n==2){
                str.append(2);
            }
            else{
                str.append(4);
            }
        }
    }
}
