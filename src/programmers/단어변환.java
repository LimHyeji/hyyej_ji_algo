package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 단어변환 {
    class Solution {
        public int solution(String begin, String target, String[] words) {
            return bfs(words,begin,target);
        }

        int bfs(String[] words, String begin, String target){
            Queue<String> q=new ArrayDeque<>();
            boolean[] visit=new boolean[words.length];

            q.add(begin);
            int cnt=0;
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    String cur=q.poll();

                    if(cur.equals(target)){
                        return cnt;
                    }

                    for(int j=0;j<words.length;j++){
                        if(!visit[j]){
                            int same=0;
                            for(int k=0;k<words[j].length();k++){
                                if(words[j].charAt(k)==cur.charAt(k)) same++;
                            }
                            if(words[j].length()-same==1){
                                q.add(words[j]);
                                visit[j]=true;
                            }
                        }
                    }

                }
                cnt++;
            }

            return 0;
        }
    }
}
