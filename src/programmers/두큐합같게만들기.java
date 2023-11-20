package programmers;

public class 두큐합같게만들기 {
    class Solution {
        public int solution(int[] queue1, int[] queue2) {
            int size=queue1.length;
            long sum=0,target=0;

            int[] queue=new int[size*2];
            for(int i=0;i<size;i++){
                sum+=queue1[i];
                target+=queue1[i];
                queue[i]=queue1[i];
            }

            int idx=size;
            for(int i=0;i<size;i++){
                target+=queue2[i];
                queue[idx++]=queue2[i];
            }
            if(target%2==1) return -1;
            target/=2;//목표합

            int left=0;
            int right=size;

            int ans=0;
            while(left<=right&&right<2*size){
                if(sum<target){
                    sum+=queue[right];
                    right++;
                }
                else if(sum>target){
                    sum-=queue[left];
                    left++;
                }
                else{
                    return ans;
                }

                ans++;
            }

            return -1;
        }
    }
}
