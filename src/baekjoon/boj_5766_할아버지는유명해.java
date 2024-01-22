package baekjoon;

import java.io.*;
import java.util.*;

public class boj_5766_할아버지는유명해 {
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st=new StringTokenizer(in.readLine());
            N=Integer.parseInt(st.nextToken());
            M=Integer.parseInt(st.nextToken());
            List<Integer> ans = new ArrayList<>();

            if(N==0&&M==0) break;

            Map<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<N;i++){
                st=new StringTokenizer(in.readLine());
                for(int j=0;j<M;j++){
                    int num = Integer.parseInt(st.nextToken());
                    map.put(num,map.getOrDefault(num,0) + 1);
                }
            }

            List<Integer> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

            int score = map.get(keySet.get(1));

            for (Integer key : keySet) {
                if (map.get(key) == score) {
                    ans.add(key);
                }
            }
            Collections.sort(ans);

            for (Integer key : ans) {
                sb.append(key).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
