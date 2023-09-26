package programmers;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 귤고르기 {
    HashMap<Integer,Integer> map=new HashMap<>();
    PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }

        for(int key:map.keySet()){
            pq.add(map.get(key));
        }

        while(true){
            if(pq.peek()>=k){
                answer++;
                break;
            }
            else{
                int temp=pq.poll();
                k-=temp;
                answer++;
            }
        }

        return answer;
    }
}
