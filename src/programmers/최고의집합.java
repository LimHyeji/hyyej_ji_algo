package programmers;

import java.util.Arrays;

public class 최고의집합 {
    class Solution {
        public int[] solution(int n, int s) {

            int q=s/n;
            int r=s%n;

            if(q<=0){
                int[] answer=new int[1];
                answer[0]=-1;
                return answer;
            }

            int[] answer = new int[n];

            for(int i=0;i<n;i++){
                if(r>0){
                    r--;
                    answer[i]=q+1;
                    continue;
                }
                answer[i]=q;
            }

            Arrays.sort(answer);

            return answer;
        }
    }
}
