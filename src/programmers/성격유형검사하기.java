package programmers;

import java.util.HashMap;

public class 성격유형검사하기 {

    class Solution {
        HashMap<Character,Integer> map=new HashMap<>();

        public String solution(String[] survey, int[] choices) {
            int size=survey.length;
            for(int i=0;i<size;i++){
                if(choices[i]<4){
                    char c=survey[i].charAt(0);
                    map.put(c,map.getOrDefault(c,0)+(4-choices[i]));
                }
                else if(choices[i]>4){
                    char c=survey[i].charAt(1);
                    map.put(c,map.getOrDefault(c,0)+(choices[i]-4));
                }
            }

            String answer="";
            if(map.getOrDefault('T',0)>map.getOrDefault('R',0)){
                answer+='T';
            }
            else{
                answer+='R';
            }

            if(map.getOrDefault('C',0)<map.getOrDefault('F',0)){
                answer+='F';
            }
            else{
                answer+='C';
            }

            if(map.getOrDefault('J',0)<map.getOrDefault('M',0)){
                answer+='M';
            }
            else{
                answer+='J';
            }

            if(map.getOrDefault('N',0)>map.getOrDefault('A',0)){
                answer+='N';
            }
            else{
                answer+='A';
            }

            return answer;
        }
    }
}
