package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;

public class Baekjoon_10814 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");		// <이름, 나이 쌍 입력받기>
			map.put(str[1], Integer.valueOf(str[0]));
		}
		
		// 나이(value) 기준으로 정렬하기
		List<String> keySet = new ArrayList<>(map.keySet());
		keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        for (String key : keySet) {
            System.out.println(map.get(key) + " " + key);
        }
	}

}
