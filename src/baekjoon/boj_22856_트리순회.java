package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_22856_트리순회 {
    static int n;

    static class Node {
        int left, right;

        Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static ArrayList<Integer> inOrder;
    static ArrayList<Node>[] g;
    static int cnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(in.readLine());

        g = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            g[a].add(new Node(b, c));
        }

        inOrder = new ArrayList<>();
        dfs(1, 0, true);
        dfs(1, 0, false);
    }

    static void dfs(int here, int pa, boolean f) {
        for (Node node : g[here]) {
            if (node.left != -1) {
                dfs(node.left, here, f);
                if (!f)
                    cnt++;
            }
            if (f) {
                inOrder.add(here);
            } else {
                if (inOrder.get(inOrder.size() - 1) == here) {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
            if (node.right != -1) {
                dfs(node.right, here, f);
                if (!f)
                    cnt++;
            }
        }
    }
}
