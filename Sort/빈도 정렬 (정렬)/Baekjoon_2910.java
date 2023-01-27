package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Baekjoon_2910 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> map = new LinkedHashMap<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]);		// 메시지 길이
		int c = Integer.parseInt(str[1]);		// 수열의 최대값
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(input[i]);
			
			if(x < 1 || x > c) {
				System.out.println("잘못된 범위값을 입력했습니다.");
				break;
			}
			
			boolean flag = map.containsKey(x);
			if(!flag)
				map.put(x, 1);
			else {
				int count = map.get(x);
				map.replace(x, ++count);
			}
		}
		
		// System.out.println(map);
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));		// value 기준으로 정렬
		
		for(Integer key : keySet) {
			for(int i=0; i<map.get(key); i++)
				System.out.print(key + " ");
		}
		
	}

}
