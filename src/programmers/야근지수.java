package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수 {
    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;

            PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
            for(int e:works){
                q.add(e);
            }
            while(n-->0){
                int cur=q.poll();
                cur--;
                q.add(cur);
            }

            for(int e:q){
                //System.out.println(e);
                if(e>0)
                    answer+=e*e;
            }

            return answer;
        }
    }
}
