package programmers;

import java.util.Stack;

public class 택배상자 {

    class Solution {
        public int solution(int[] order) {
            int want=0, cur=1;
            Stack<Integer> s=new Stack<>();

            while(true){
                if(!s.isEmpty()&&s.peek()==order[want]){
                    s.pop();
                    want++;
                    continue;
                }

                if(cur>order.length) break;

                if(order[want]==cur){
                    want++;
                    cur++;
                    continue;
                }

                s.push(cur);
                cur++;
            }

            return want;
        }
    }
}
