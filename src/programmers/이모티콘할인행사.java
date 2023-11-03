package programmers;

import java.util.PriorityQueue;

public class 이모티콘할인행사 {
    class Solution {
        public class 결과 implements Comparable<결과>{
            int 가입자수,판매액;
            결과(int 가입자수,int 판매액){
                this.가입자수=가입자수;
                this.판매액=판매액;
            }
            public int compareTo(결과 o){
                if(this.가입자수==o.가입자수) return Integer.compare(o.판매액,this.판매액);
                return Integer.compare(o.가입자수,this.가입자수);
            }
        }


        int n,m;
        int[][] 사용자들;
        int[] 이모티콘들;
        PriorityQueue<결과> pq=new PriorityQueue<>();
        int[] arr={10,20,30,40};
        int[] num;

        public int[] solution(int[][] users, int[] emoticons) {
            n=users.length; m=emoticons.length;
            사용자들=users; 이모티콘들=emoticons;

            num=new int[m];
            per(0);

            결과 결과=pq.poll();
            return new int[] {결과.가입자수,결과.판매액};
        }

        void per(int cnt){
            if(cnt==m){
                confirm(num);
                return;
            }

            for(int i=0;i<arr.length;i++){
                num[cnt]=arr[i];
                per(cnt+1);
            }

        }

        public void confirm(int[] num){
            int 가입자수=0,판매액=0;
            for(int i=0;i<n;i++){
                int 비율=사용자들[i][0];
                int 한도=사용자들[i][1];
                int 구입액=0;
                for(int j=0;j<m;j++){
                    int 할인가격=이모티콘들[j]/100*(100-num[j]);
                    if(비율<=num[j]) 구입액+=할인가격;
                }
                if(한도<=구입액){
                    가입자수++;
                }
                else{
                    판매액+=구입액;
                }
            }
            pq.add(new 결과(가입자수,판매액));
        }
    }
}
