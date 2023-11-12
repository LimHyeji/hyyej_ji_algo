package programmers;

import java.util.*;

public class 베스트앨범 {
    class Solution {
        public class Song implements Comparable<Song>{
            int num,play;
            Song(int num,int play){
                this.num=num;
                this.play=play;
            }

            public int compareTo(Song o){
                if(this.play==o.play) return Integer.compare(this.num,o.num);
                else return Integer.compare(o.play,this.play);
            }
        }

        public int[] solution(String[] genres, int[] plays) {
            int n=genres.length;
            HashMap<String,Integer> map=new HashMap<>();//장르와 각 플레이 횟수 저장할 맵
            HashMap<String,List<Song>> songs=new HashMap<>();//장르별 노래 리스트 저장할 맵

            List<Integer> answer=new ArrayList<>();

            for(int i=0;i<n;i++){
                map.put(genres[i],map.getOrDefault(genres[i],0)+plays[i]);
                List<Song> tempList=songs.get(genres[i]);
                if(tempList==null){
                    List<Song> addList=new ArrayList<>();
                    addList.add(new Song(i,plays[i]));
                    songs.put(genres[i],addList);
                }
                else{
                    tempList.add(new Song(i,plays[i]));
                    songs.put(genres[i],tempList);
                }
            }

            /* 맵 VALUE로 정렬하는 방법! */
            List<Map.Entry<String, Integer>> list
                    = new LinkedList<>(map.entrySet());
            list.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

            for(int i=0;i<list.size();i++){
                String key=list.get(i).getKey();
                List<Song> songList=songs.get(key);
                if(songList.size()==1){
                    answer.add(songList.get(0).num);
                }
                else{
                    Collections.sort(songList);
                    answer.add(songList.get(0).num);
                    answer.add(songList.get(1).num);
                }
            }

            int[] result=new int[answer.size()];
            for(int i=0;i<answer.size();i++){
                result[i]=answer.get(i);
            }
            return result;
        }
    }
}
