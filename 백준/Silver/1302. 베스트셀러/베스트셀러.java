import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) {
            String book = br.readLine();

            if(map.get(book) == null) {
                map.put(book, 1);
            } else {
                map.put(book, 1 + map.get(book));
            }
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(Objects.equals(o1.getValue(), o2.getValue())) {
                    return o1.getKey().compareTo(o2.getKey()); // 제목을 기준으로 사전순 정렬
                }
                return o2.getValue() - o1.getValue(); // 내림차순 정렬
            }
        });

        System.out.print(entryList.get(0).getKey());
    }
}