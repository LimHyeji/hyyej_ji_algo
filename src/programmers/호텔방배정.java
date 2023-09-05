package programmers;

import java.util.HashMap;

public class 호텔방배정 {
    class Solution {
        HashMap<Long,Long> map=new HashMap<>();

        public long[] solution(long k, long[] room_number) {
            long[] answer = new long[room_number.length];

            for(int i=0;i<room_number.length;i++){
                answer[i]=findEmptyRoom(room_number[i]);
            }

            return answer;
        }

        public long findEmptyRoom(long room){
            if(map.get(room)==null){
                map.put(room,room+1);
                return room;
            }

            long next=map.get(room);
            long empty=findEmptyRoom(next);
            map.put(room,empty);
            return empty;
        }
    }
}
