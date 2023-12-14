import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 개수 + 자릿수에 대한 가중치로 정렬
        // ex) GCF -> 100G + 10C + 1F
        // ex) ABCD -> 1000A + 100B + 10C + 1D
        // 둘의 합은 1000A + 100B + 20C + 1D + 100G + 1F -> 계수가 큰 순서대로 알파벳에 9, 8, 7 ... 할당하면 끝

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 단어 입력 받기
        ArrayList<String> word = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            word.add(br.readLine());
        }

        // <알파벳, 개수> 담을 map 선언 및 초기화
        Map<Character, Double> map = new HashMap<>();
        for(int i = 0; i < 26; i++){
            map.put((char)('A' + i), 0d);
        }

        for(String w : word) {
            for(int i = w.length() - 1; i >= 0; i--){
                // map에서 꺼내서 자릿수 더한값으로 다시 넣기
                map.put(w.charAt(i), map.get(w.charAt(i)) + Math.pow(10, w.length() - i - 1));
            }
        }

        // map 내림차순 정렬
        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int sum = 0;    // 단어 총 합
        int count = 9;
        for(Character c : list) {
            if(map.get(c) != 0d)
                sum += map.get(c) * count--;
        }

        System.out.println(sum);
    }
}