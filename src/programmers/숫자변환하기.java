package programmers;

public class 숫자변환하기 {
    class Solution {
        public int solution(int x, int y, int n) {
            int[] dp=new int[y+1];

            for(int i=x;i<y+1;i++){
                if(i!=x&&dp[i]==0){
                    dp[i]=-1;
                    continue;
                }

                if(i+n<=y) dp[i+n]=dp[i+n]==0?dp[i]+1:Math.min(dp[i+n],dp[i]+1);
                if(i*2<=y) dp[i*2]=dp[i*2]==0?dp[i]+1:Math.min(dp[i*2],dp[i]+1);
                if(i*3<=y) dp[i*3]=dp[i*3]==0?dp[i]+1:Math.min(dp[i*3],dp[i]+1);

            }

            return dp[y];
        }
    }
}
