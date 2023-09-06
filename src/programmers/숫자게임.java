package programmers;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class 숫자게임 {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            ArrayList<Integer> a=new ArrayList<>();
            ArrayList<Integer> bTemp=new ArrayList<>();
            for(int i=0;i<A.length;i++){
                a.add(A[i]);
                bTemp.add(B[i]);
            }

            Collections.sort(a, Collections.reverseOrder());
            Collections.sort(bTemp, Collections.reverseOrder());

            ArrayDeque<Integer> b=new ArrayDeque<>(bTemp);

            int size=a.size();
            for(int i=0;i<size;i++){
                if(b.getFirst()>a.get(i)){
                    answer++;
                    b.removeFirst();
                }
                else{
                    b.removeLast();
                }
            }
            return answer;
        }
    }
}
