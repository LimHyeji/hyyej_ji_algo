package programmers;

public class 카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            brown-=4;
            brown/=2;

            int width=0,height=0;
            int last=(int)Math.sqrt(yellow)+1;
            for(int i=1;i<last;i++){
                if(yellow%i==0){
                    if(brown==yellow/i+i){
                        width=Math.max(yellow/i,i)+2;
                        height=Math.min(yellow/i,i)+2;
                        break;
                    }
                }
            }
            return new int[] {width,height};
        }
    }
}
