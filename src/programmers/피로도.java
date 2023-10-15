package programmers;

public class 피로도 {
    class Solution {
        int total, n;
        int[] num;
        boolean[] sel;
        int[][] map;
        int res;

        public void per(int cnt){
            if(cnt==n){
                go(num);
                return;
            }

            for(int i=0;i<n;i++){
                if(sel[i]) continue;

                num[cnt]=i;
                sel[i]=true;
                per(cnt+1);
                sel[i]=false;
            }
        }

        public void go(int[] num){
            int k=total;
            for(int i=0;i<n;i++){
                int need=map[num[i]][0];
                int wage=map[num[i]][1];

                if(k>=need){
                    k-=wage;

                }
                else{
                    res=Math.max(res,i);
                    return;
                }
            }
            res=n;
        }

        public int solution(int k, int[][] dungeons) {
            total=k;
            n=dungeons.length;
            num=new int[n];
            sel=new boolean[n];
            map=dungeons;
            res=0;
            per(0);
            return res;
        }
    }
}
