package programmers;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 숫자게임 {
    class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);
            ArrayDeque<Integer> a=new ArrayDeque<>();
            ArrayDeque<Integer> b=new ArrayDeque<>();
            for(int i=A.length-1;i>=0;i--){
                a.add(A[i]);
                b.add(B[i]);
            }

            int size=a.size();
            for(int i=0;i<size;i++){
                if(b.getFirst()>a.getFirst()){
                    answer++;
                    b.removeFirst();
                    a.removeFirst();
                }
                else{
                    b.removeLast();
                    a.removeFirst();
                }
            }
            return answer;
        }
    }
}
