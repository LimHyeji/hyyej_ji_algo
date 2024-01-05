package baekjoon;

import java.io.*;
import java.util.*;

public class boj_1700_멀티탭스케줄링 {
    static int n, k, res;
    static int[] arr;
    static Set<Integer> tap;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[k];
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        if (n < k) {
            tap = new HashSet<>();
            map = new HashMap<>();

            for (int i = 0; i < k; i++) {
                if (tap.contains(arr[i])) {
                    continue;
                }
                if (tap.size() < n) {
                    tap.add(arr[i]);
                    continue;
                }

                map.clear();
                for (int num : tap) {
                    map.put(num, Integer.MAX_VALUE);
                }
                for (int j = i + 1; j < k; j++) {
                    if (map.get(arr[j]) != null && map.get(arr[j]) == Integer.MAX_VALUE) {
                        map.put(arr[j], j - i);
                    }
                }

                List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
                entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return Integer.compare(o2.getValue(), o1.getValue());
                    }
                });
                for (Map.Entry<Integer, Integer> entry : entryList) {
                    tap.remove(entry.getKey());
                    break;
                }
                tap.add(arr[i]);
                res++;
            }
        }

        out.write(String.valueOf(res));
        out.close();
        in.close();
    }
}
