package programmers;

import java.util.Stack;

public class 뒤에있는큰수찾기 {

    class Solution {
        Stack<Integer> s;

        public int[] solution(int[] numbers) {
            int size=numbers.length;
            int[] answer = new int[size];

            s=new Stack<>();
            answer[size-1]=-1;

            for(int idx=size-1;idx>=0;idx--){
                while(!s.isEmpty()){
                    if(s.peek()>numbers[idx]){
                        answer[idx]=s.peek();
                        break;
                    }
                    s.pop();
                }
                if(answer[idx]==0) {
                    answer[idx]=-1;
                }

                s.push(numbers[idx]);
            }

            return answer;
        }
    }
}
