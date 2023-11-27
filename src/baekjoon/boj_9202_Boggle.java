package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class boj_9202_Boggle {

    static int w,b;
    static Set<String> words;
    static char[][] map;
    static boolean[][] visit;
    static Set<String> findWords;
    static int score,find;

    static int[] dirR={-1,1,0,0,-1,-1,1,1};
    static int[] dirC={0,0,-1,1,-1,1,-1,1};
    static class Node{
        int row,col;
        Node(int row,int col){
            this.row=row;
            this.col=col;
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
    static StringBuilder str;

    public static void main(String[] args) throws IOException {
        initAndSol();
        print();
    }

    public static void initAndSol() throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        w=Integer.parseInt(in.readLine());

        trie=new Trie();

        words=new HashSet<>();
        for(int i=0;i<w;i++){
            String word=in.readLine();
            words.add(word);

            trie.insert(word);
        }

        in.readLine();

        map=new char[4][4];
        visit=new boolean[4][4];
        str=new StringBuilder();

        b=Integer.parseInt(in.readLine());
        while(true){

            for(int i=0;i<4;i++){
                map[i]=in.readLine().toCharArray();
            }
            findWords=new HashSet<>();
            score=0;find=0;
            sol();

            b--;
            if(b==0) break;
            in.readLine();
        }
    }

    public static void sol(){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                visit[i][j]=true;
                dfs(i,j,String.valueOf(map[i][j]));
                visit[i][j]=false;
            }
        }

        appendResult();
    }

    public static void dfs(int row,int col,String word){
        if(!trie.search(word)) return;
        if(words.contains(word)&&!findWords.contains(word)){
            findWords.add(word);
            score+=getScore(word.length());
            find++;
        }

        for(int dir=0;dir<8;dir++){
            int newR=row+dirR[dir];
            int newC=col+dirC[dir];
            if(newR<0||newR>=4||newC<0||newC>=4||visit[newR][newC]) continue;

            visit[newR][newC]=true;
            dfs(newR,newC,word+map[newR][newC]);
            visit[newR][newC]=false;
        }
    }

    public static int getScore(int len){
        switch(len){
            case 8: return 11;
            case 7: return 5;
            case 6: return 3;
            case 5: return 2;
            case 4:
            case 3: return 1;
            default: return 0;
        }
    }

    public static void appendResult(){
        int maxLen=0; String maxStr="";
        for(String word:findWords){
            if(word.length()>maxLen){
                maxLen=word.length();
                maxStr=word;
            }
            else if(word.length()==maxLen){
                int compare=maxStr.compareTo(word);
                if(compare>0) maxStr=word;
            }
        }

        str.append(score).append(" ").append(maxStr).append(" ").append(find).append("\n");
    }

    public static void print() throws IOException {
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        out.write(str.toString());
        out.close();
    }
}