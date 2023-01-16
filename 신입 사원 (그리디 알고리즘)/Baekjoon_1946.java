package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Baekjoon_1946 {

	public static int maxEmployees(HashMap<Integer, Integer> map) {
		int count = 0;
		
		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);				// 서류 순위로 오름차순 정렬
		
		int min = map.get(keySet.get(0));		// 서류 1등의 면접 등수로 초기화
		for(Integer key : keySet) {
			if(map.get(key) < min) {
				count++;
				min = map.get(key);
			}		
		}
		
		return count + 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();					// 테스트 케이스 개수
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();				// 지원자의 숫자 (1 <= n <= 100000)
			
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for(int j=0; j<n; j++) {
				map.put(sc.nextInt(), sc.nextInt());
			}
			
			System.out.println(maxEmployees(map));
		}
	}

}
