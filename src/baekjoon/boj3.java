package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj3 {
    /*
     * 왼쪽 서브트리 모든 키는 자기 키보다 작음 오른쪽 서브트리 모든 키는 자기 키보다 큼 왼쪽 오른쪽 서브트리도 이진 검색 트리
     *
     * 처음값 -> ROOT 이후 내림차순 값 -> 모두 LEFT CHILD 처음으로 오름차순 -> ROOT까지는 RIGHT CHILD 채우고,
     * 이후 오름차순 전까지 LEFT CHILD
     */

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key){
            this.key=key;
        }

        Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if(n<this.key) {
                if(this.left==null) {
                    this.left=new Node(n);
                }
                else {
                    this.left.insert(n);
                }
            }
            else {
                if(this.right==null) {
                    this.right=new Node(n);
                }
                else {
                    this.right.insert(n);
                }
            }
        }
    }

    static void postOrder(Node node) {
        if(node==null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.key);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        Node root=new Node(Integer.parseInt(in.readLine()));
        while(true) {
            String input=in.readLine();
            if(input==null||input.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(input));
        }
        postOrder(root);
    }
}
