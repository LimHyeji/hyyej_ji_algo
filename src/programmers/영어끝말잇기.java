package programmers;

import java.util.HashSet;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        HashSet<String> set=new HashSet<>();
        String temp=words[0];
        set.add(temp);
        boolean flag=false;
        for(int i=1;i<words.length;i++){
            if(temp.charAt(temp.length()-1)==words[i].charAt(0)){
                if(!set.contains(words[i])){
                    set.add(words[i]);
                    temp=words[i];
                    continue;
                }
            }

            int num=(i+1)%n;
            if(num==0){
                answer[0]=n;
                answer[1]=(i+1)/n;
                flag=true;
                break;
            }
            else{
                answer[0]=num;
                answer[1]=(i+1)/n+1;
                flag=true;
                break;
            }
        }

        if(!flag){
            answer[0]=0;
            answer[1]=0;
        }

        return answer;
    }
}
