package programmers;

import java.util.HashMap;

public class 캐시 {
    class Solution {
        public int solution(int cacheSize, String[] cities) {
            if(cacheSize==0) return cities.length*5;

            int answer = 0;
            HashMap<String,Integer> map=new HashMap<>();

            int size=0;
            for(int i=0;i<cities.length;i++){
                String temp=cities[i].toUpperCase();

                if(map.get(temp)!=null){//cache hit
                    map.put(temp,i);//최근 사용된 시점 업데이트
                    answer++;
                    continue;
                }

                //무조건 add
                if(size<cacheSize&&map.get(temp)==null){
                    //캐시 사이즈 여유가 있으면서, Cache Miss
                    map.put(temp,i);
                    answer+=5;
                    size++;
                }
                else{
                    String min=null;//가장 오래전에 사용된 단어
                    int min_num=Integer.MAX_VALUE;
                    for(String key:map.keySet()){
                        if(min_num>map.get(key)){
                            min=key;
                            min_num=map.get(key);
                        }
                    }
                    map.remove(min);
                    map.put(temp,i);
                    answer+=5;
                }
            }
            return answer;
        }
    }
}
