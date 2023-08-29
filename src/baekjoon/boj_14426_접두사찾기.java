package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_14426_접두사찾기 {
    static int n,m;
    static class Node{
        HashMap<Character,Node> childNodes=new HashMap<>();
        Node(){}
    }

    static class Trie{
        Node root;

        Trie(){
            this.root=new Node();
        }

        void insert(String str){
            Node node=this.root;

            for(int i=0;i<str.length();i++){
                node=node.childNodes.computeIfAbsent(str.charAt(i),character -> new Node());
            }
        }

        boolean search(String str){
            Node node=this.root;

            for(int i=0;i<str.length();i++){
                if(!node.childNodes.containsKey(str.charAt(i))) return false;
                node=node.childNodes.get(str.charAt(i));
            }
            return true;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(in.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        Trie trie=new Trie();

        for(int i=0;i<n;i++){
            String input=in.readLine();
            trie.insert(input);
        }

        int res=0;
        for(int i=0;i<m;i++){
            String input=in.readLine();
            if(trie.search(input)) res++;
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
