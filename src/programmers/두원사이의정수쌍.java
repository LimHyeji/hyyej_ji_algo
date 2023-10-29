package programmers;

public class 두원사이의정수쌍 {
    class Solution {
        public long solution(int r1, int r2) {
            long answer = 0;

            for (int i = 1; i <= r2; i++) {
                long start = (long)Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
                long end = (long)Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)));

                answer += end-start+1;
            }

            return answer*4;
        }
    }
}
