package baekjoon;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class boj_9202_Boggle {
    static int w,b;
    static String[] words;
    static char[][] map;
    static StringBuilder str;
    static class Node{
        int row,col;
        String word;
        Node(int row,int col,String word){
            this.row=row;
            this.col=col;
            this.word=word;
            trie.insert(word);
        }
    }
    static int[] dirR={-1,1,0,0,-1,-1,1,1};
    static int[] dirC={0,0,-1,1,-1,1,-1,1};

    static class Word implements Comparable<Word>{
        String word;

        Word(String word) {this.word=word;}

        public int compareTo(Word o){
            if(this.word.length()==o.word.length()){
                return this.word.compareTo(o.word);
            }
            else return Integer.compare(o.word.length(),this.word.length());
        }
    }

    static class TrieNode{
        Map<Character,TrieNode> child;
        boolean end;

        TrieNode(){
            this.child=new HashMap<>();
            this.end=false;
        }
    }
    static class Trie{
        TrieNode root;

        Trie(){
            root=new TrieNode();
        }

        void insert(String str){
            TrieNode node=this.root;
            for(int i=0;i<str.length();i++){
                node.child.computeIfAbsent(str.charAt(i),key->new TrieNode());
                node=node.child.get(str.charAt(i));
            }
            node.end=true;
        }

        boolean search(String str){
            TrieNode node=this.root;
            for(int i=0;i<str.length();i++){
                node=node.child.getOrDefault(str.charAt(i),null);
                if(node==null) return false;
            }
            return true;
        }
    }
    static Trie trie;

    public static void main(String[] args) throws IOException {
        initAndSol();
        print();
    }

    public static void initAndSol() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        w=Integer.parseInt(in.readLine());
        words=new String[w];
        for(int i=0;i<w;i++){
            words[i]=in.readLine();
        }

        str=new StringBuilder();

        in.readLine();//빈줄
        b=Integer.parseInt(in.readLine());
        while(true) {
            map = new char[4][4];
            for (int i = 0; i < 4; i++) {
                String input = in.readLine();
                for (int j = 0; j < 4; j++) {
                    map[i][j]=input.charAt(j);
                }
            }

            sol();

            if(b==0) break;
            in.readLine();//빈줄
            b--;
        }
        in.close();
    }

    public static void sol(){
        trie=new Trie();
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                insertTrie(i,j);
            }
        }

        int maxScore=0,find=0;
        List<Word> list=new ArrayList<>();
        for(int i=0;i<w;i++){
            if(trie.search(words[i])){
                int score=getScore(words[i].length());
                maxScore=Math.max(maxScore,score);
                find++;
                list.add(new Word(words[i]));
            }
        }
        Collections.sort(list);
        str.append(maxScore).append(" ").append(list.get(0)).append(" ").append(find).append("\n");
    }

    public static void insertTrie(int i,int j){
        boolean[][] visit=new boolean[4][4];
        Queue<Node> q=new ArrayDeque<>();

        q.add(new Node(i,j,String.valueOf(map[i][j])));
        visit[i][j]=true;

        while(!q.isEmpty()){
            Node cur=q.poll();
            for(int dir=0;dir<8;dir++){
                int newR=cur.row+dirR[dir];
                int newC=cur.col+dirC[dir];

                if(newR<0||newR>=4||newC<0||newC>=4||visit[newR][newC]) continue;

                q.add(new Node(newR,newC,cur.word+map[newR][newC]));
                visit[newR][newC]=true;
            }
        }
    }

    public static int getScore(int len){
        switch(len){
            case 8: return 11;
            case 7: return 5;
            case 6: return 3;
            case 5: return 2;
            case 4: return 1;
            default: return 0;
        }
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(str.toString());
        out.close();
    }
}