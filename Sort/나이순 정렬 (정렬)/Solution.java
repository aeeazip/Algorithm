package baekjoon;


import java.util.*;
import java.io.*;

public class Baekjoon_10814 {

	// case 1) 시간 초과 발생

	// public static void main(String[] args) throws IOException {
	// 	// TODO Auto-generated method stub
	// 	LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
	// 	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	// 	int n = Integer.parseInt(br.readLine());
	// 	for(int i=0; i<n; i++) {
	// 		String[] str = br.readLine().split(" ");		// <이름, 나이 쌍 입력받기>
	// 		map.put(str[1], Integer.valueOf(str[0]));
	// 	}
		
	// 	// 나이(value) 기준으로 정렬하기
	// 	List<String> keySet = new ArrayList<>(map.keySet());
	// 	keySet.sort(new Comparator<String>() {
    //         @Override
    //         public int compare(String o1, String o2) {
    //             return map.get(o1).compareTo(map.get(o2));
    //         }
    //     });

    //     for (String key : keySet) {
    //         System.out.println(map.get(key) + " " + key);
    //     }
	// }
	
	// case 2) 정상 작동
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<Integer, List<String>> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++){
			String[] str = br.readLine().split(" ");

			if(!map.containsKey(Integer.parseInt(str[0]))){		// map에 해당하는 나이가 없는 경우
				List<String> list = new ArrayList<String>();
				list.add(str[1]);
				map.put(Integer.parseInt(str[0]), list);
			} else{						// map에 해당하는 나이가 있는 경우
				List<String> list = map.get(Integer.parseInt(str[0]));
				list.add(str[1]);
				map.put(Integer.parseInt(str[0]), list);
			}
		}

		// 나이를 기준으로 정렬하기
		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);

		// 정렬한 순서대로 출력하기
		for(Integer key : keySet){
			List<String> list = map.get(key);
			for(String s : list){
				System.out.println(key + " " + s);
			}
		}
	}
}

