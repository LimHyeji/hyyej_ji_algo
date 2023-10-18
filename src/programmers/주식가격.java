package programmers;

import java.util.Stack;

public class 주식가격 {
    class Solution {
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Stack<Integer> s=new Stack<>();
            for(int idx=0;idx<prices.length;idx++){
                while(!s.isEmpty()&&prices[idx]<prices[s.peek()]){
                    answer[s.peek()]=idx-s.peek();
                    s.pop();
                }
                s.push(idx);
            }

            while(!s.isEmpty()){
                answer[s.peek()]=prices.length-s.pop()-1;
            }

            return answer;
        }
    }
}
