package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/* 미완 */
public class Main03 {
    static int n;
    static HashSet<Integer> p0;
    static HashSet<Integer> p1;

    static int[] card;
    static int[] order;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        n = Integer.parseInt(in.readLine());
        p0 = new HashSet<>();
        p1 = new HashSet<>();

        card = new int[n];
        order = new int[n];

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (input == 0) {
                p0.add(i);
            } else if (input == 1) {
                p1.add(i);
            }
        }

        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(st.nextToken());
            order[i] = card[i];
        }

        if (give()) {
            System.out.println(0);
            System.exit(0);
        } else {
            int cnt = 0;
            boolean f = false;
            while (check()) {
                turn();
                cnt++;
                if (give()) {
                    f = true;
                    break;
                }
            }
            System.out.println(f == true ? cnt : -1);
        }

    }

    static boolean give() {
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0) {
                if (p0.contains(card[i])) {
                    continue;
                } else
                    return false;
            } else if (i % 3 == 1) {
                if (p1.contains(card[i])) {
                    continue;
                } else
                    return false;
            } else {
                if (!p0.contains(card[i]) && !p1.contains(card[i])) {
                    continue;
                } else
                    return false;
            }
        }

        return true;
    }

    static void turn() {
        int[] card2 = new int[n];
        for (int i = 0; i < n; i++) {
            card2[order[i]] = card[i];
        }
        for (int i = 0; i < n; i++) {
            card[i] = card2[i];
        }
    }

    static boolean check() {
        for (int i = 0; i < n; i++) {
            if (card[i] != order[i]) {
                return true;
            }
        }
        return false;
    }
}
