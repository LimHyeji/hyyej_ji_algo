package programmers;

public class 모음사전 {

    class Solution {
        char [] 모음={'A','E','I','O','U'};
        int[] x={781,156,31,6,1};

        public int solution(String word) {
            int answer = word.length();
            for(int i=0;i<word.length();i++){
                for(int j=0;j<5;j++){
                    if(모음[j]==word.charAt(i)){
                        answer+=x[i]*j;
                    }
                }
            }
            return answer;
        }
    }
}
