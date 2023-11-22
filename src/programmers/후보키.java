package programmers;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 후보키 {

    class Solution {
        int n,size,res;
        boolean[] sel;
        String[][] input;
        Set<String> resultSet;

        public int solution(String[][] relation) {

            init(relation);

            for(int i=1;i<n;i++){
                sel=new boolean[n];
                com(0,0,i);
            }

            confirm();

            return res;
        }

        public void init(String[][] relation){
            n=relation[0].length;
            size=relation.length;
            res=0;
            input=relation;
            resultSet=new TreeSet<>();
        }

        public void com(int cnt,int start,int limit){
            if(cnt==limit){
                if(sol(sel)) res++;
                return;
            }

            for(int i=start;i<n;i++){
                if(sel[i]) continue;

                sel[i]=true;
                com(cnt+1,i+1,limit);
                sel[i]=false;
            }
        }

        public boolean sol(boolean[] visit){
            HashSet<String> keys=new HashSet<>();
            HashSet<String> values=new HashSet<>();
            for(int i=0;i<size;i++){
                String strKeys="";
                String strValues="";
                for(int j=0;j<n;j++){
                    if(visit[j]) strKeys+=input[i][j];
                    else strValues+=input[i][j];
                }
                if(keys.contains(strKeys)||values.contains(strValues)) return false;
                keys.add(strKeys);
                values.add(strValues);
            }

            String result="";
            for(int i=0;i<visit.length;i++){
                if(visit[i]) result+=String.valueOf(i);
            }
            resultSet.add(result);

            return true;
        }

        public void confirm(){
            for(String a:resultSet){
                for(String b:resultSet){
                    if(a.equals(b)) continue;
                    if(a.contains(b)) res--;
                }
            }
        }
    }
}
