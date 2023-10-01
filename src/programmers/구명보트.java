package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class 구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            ArrayList<Integer> list=new ArrayList<>();
            for(int e: people){
                list.add(e);
            }
            Collections.sort(list);

        /*
        정렬 후, 가장 무거운 사람을 태우고, 가장 가벼운 사람과 함께 태울 수 있으면 그렇게 하기
        */
            int left=0;
            int right=list.size()-1;
            while(left<=right){
                if(list.get(left)+list.get(right)<=limit){
                    left++;
                }
                right--;
                answer++;
            }

            return answer;
        }
    }
}
