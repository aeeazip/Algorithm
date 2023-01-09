package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Baekjoon_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		
		int n = Integer.parseInt(num[0]);
		int m = Integer.parseInt(num[1]);
		
		// 시간 초과 잡기 위해 HashSet 사용해서 듣도 못한 사람의 set에 보도 못한 사람의 set이 있는지 검사
		// HashSet = Set 인터페이스에서 지원하는 구현 클래스 
		// 순서대로 입력되지 않고, 일정하게 유지, null도 허용, 중복 허용 X
		
		HashSet<String> set = new HashSet<String>();
		for(int i=0; i<n; i++) // 듣도 못한 사람 HashSet에 담기
			set.add(br.readLine());
		
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			
			// HashSet.contains(Object) : set 안에 객체의 존재 여부를 리턴해준다.
			if(set.contains(str))
				result.add(str);
		}
		
		Collections.sort(result);
		
		System.out.println(result.size());
		for(String s : result) 
			System.out.println(s);
			
	}

}
