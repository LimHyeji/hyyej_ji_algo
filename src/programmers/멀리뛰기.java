package programmers;

import java.util.Arrays;

public class 멀리뛰기 {
    class Solution {
        public int solution(int[] citations) {

            Arrays.sort(citations);
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=citations.length-i){
                    return citations.length-i;
                }
            }

            return 0;
        }
    }
}
