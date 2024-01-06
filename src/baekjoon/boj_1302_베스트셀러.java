package baekjoon;

import java.io.*;
import java.util.*;

public class boj_1302_베스트셀러 {
    static int N;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String title = in.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) return o1.getKey().compareTo(o2.getKey());
                return Integer.compare(o2.getValue(), o1.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry : entryList) {
            out.write(entry.getKey());
            break;
        }

        out.close();
        in.close();
    }
}
