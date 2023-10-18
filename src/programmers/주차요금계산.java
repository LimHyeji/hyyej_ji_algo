package programmers;

import java.util.HashMap;
import java.util.TreeMap;

public class 주차요금계산 {
    class Solution {
        TreeMap<Integer,Integer> timeMap=new TreeMap<>();
        HashMap<Integer,Integer> in=new HashMap<>();

        public int[] solution(int[] fees, String[] records) {
            for(int i=0;i<records.length;i++){
                String[] data=records[i].split(" ");

                String[] time=data[0].split(":");
                int hour=Integer.parseInt(time[0]);
                int minute=Integer.parseInt(time[1]);

                int car=Integer.parseInt(data[1]);
                String cmd=data[2];

                if(cmd.equals("IN")){
                    in.put(car,60*hour+minute);
                    timeMap.put(car,timeMap.getOrDefault(car,0));
                }
                else{
                    int total=(hour*60+minute)-in.get(car);

                    timeMap.put(car,timeMap.getOrDefault(car,0)+total);
                    in.put(car,-1);
                }
            }

            int[] answer=new int[timeMap.size()];
            int idx=0;
            for(int key:timeMap.keySet()){
                if(in.get(key)!=-1){
                    int time=(23*60+59)-in.get(key);
                    timeMap.put(key,timeMap.getOrDefault(key,0)+time);
                }

                int total=timeMap.get(key);
                int fee=0;
                if(total>=fees[0]){
                    fee+=fees[1];
                    total-=fees[0];
                    total=total%fees[2]>0?total/fees[2]+1:total/fees[2];
                    fee+=total*fees[3];
                }
                else{
                    fee=fees[1];
                }

                answer[idx++]=fee;
            }

            return answer;
        }
    }
}
