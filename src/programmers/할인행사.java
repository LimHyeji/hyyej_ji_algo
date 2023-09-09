package programmers;

import java.util.HashMap;

public class 할인행사 {
    class Solution {
        public int solution(String[] want, int[] number, String[] discount) {
            int answer = 0;
            HashMap<String,Integer> map=new HashMap<>();

            for(int i=0;i<want.length;i++){
                map.put(want[i],number[i]);
            }

            for(int i=0;i<=discount.length-10;i++){
                HashMap<String,Integer> temp=new HashMap<>();

                for(int j=0;j<10;j++){
                    temp.put(discount[i+j],temp.getOrDefault(discount[i+j],0)+1);
                }

                boolean flag=true;
                for(String key:map.keySet()){
                    if(temp.get(key)!=map.get(key)){
                        flag=false;
                        break;
                    }
                }

                if(flag) answer++;

            }

            return answer;
        }
    }
}
