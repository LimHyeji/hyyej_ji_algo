package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class H_INDEX {
    class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            ArrayList<Integer> list=new ArrayList<>();

            for(int i=0;i<citations.length;i++){
                list.add(citations[i]);
            }

            Collections.sort(list, Collections.reverseOrder());

            for(int i=0;i<list.size();i++){
                if(list.get(i)>i){
                    answer++;
                }
            }

            return answer;
        }
    }
}
