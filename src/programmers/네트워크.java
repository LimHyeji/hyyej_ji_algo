package programmers;

import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit=new boolean[n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(computers[i][j]==1){
                    Queue<Integer> q=new ArrayDeque<>();
                    q.add(i);
                    computers[i][j]=-1;
                    visit[i]=true;
                    while(!q.isEmpty()){
                        int cur=q.poll();

                        for(int k=0;k<n;k++){
                            if(computers[cur][k]==1){
                                computers[cur][k]=-1;
                                if(!visit[k]){
                                    q.add(k);
                                    visit[k]=true;
                                }
                            }
                        }
                    }
                    answer++;
                }
            }
        }


        return answer;
    }
}
