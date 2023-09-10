package programmers;

public class 단속카메라 {
    class Solution {

        class Node implements Comparable<Node> {
            int start, end;

            Node(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Node o) {
                return Integer.compare(this.end, o.end);
            }
        }
    }
}