package programmers;

public class 연속된부분수열의합 {
    class Solution {
        public int[] solution(int[] sequence, int k) {
            int[] answer=new int[2];
            int left=0,right=0;
            int sum=0;
            int len=Integer.MAX_VALUE;

            while(true){
                if(sum>=k){
                    sum-=sequence[left++];
                }
                else if(right>=sequence.length){
                    break;
                }
                else{
                    sum+=sequence[right++];
                }

                if(sum==k&&len>right-left){
                    len=right-left;
                    answer[0]=left;
                    answer[1]=right-1;
                }
            }
            return answer;
        }
    }
}
