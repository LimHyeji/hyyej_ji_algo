package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 섬연결하기 {

    class Solution {
        int n;
        int[] par;

        int find(int a){
            if(par[a]==a) return a;
            return find(par[a]);
        }

        boolean union(int a,int b){
            int parA=find(a);
            int parB=find(b);

            if(parA==parB) return false;

            if(parA<parB){
                par[b]=parA;
                for(int i=0;i<n;i++){
                    if(parB==par[i]) par[i]=parA;
                }
            }
            else{
                par[a]=parB;
                for(int i=0;i<n;i++){
                    if(parA==par[i]) par[i]=parB;
                }
            }
            return true;
        }

        class Node implements Comparable<Node>{
            int a,b,cost;
            Node(int a,int b,int cost){
                this.a=a;
                this.b=b;
                this.cost=cost;
            }

            public int compareTo(Node o){
                return Integer.compare(this.cost,o.cost);
            }
        }
        List<Node> list;

        public int solution(int n, int[][] costs) {
            int answer = 0;
            this.n=n;

            par=new int[n];
            for(int i=0;i<n;i++){
                par[i]=i;
            }

            list=new ArrayList<>();
            for(int i=0;i<costs.length;i++){
                int a=costs[i][0];
                int b=costs[i][1];
                int cost=costs[i][2];
                list.add(new Node(a,b,cost));
            }

            Collections.sort(list);

            for(int i=0;i<list.size();i++){
                Node cur=list.get(i);
                if(union(cur.a,cur.b)){
                    answer+=cur.cost;
                }

                boolean flag=true;
                int curPar=par[0];
                for(int j=1;j<n;j++){
                    if(curPar!=par[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) break;
            }

            return answer;
        }
    }
}
