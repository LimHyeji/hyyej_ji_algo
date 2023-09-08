package programmers;

import java.util.Arrays;

public class H_INDEX {
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
