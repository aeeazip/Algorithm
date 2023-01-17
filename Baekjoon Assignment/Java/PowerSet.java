package baekjoon;

// 멱집합 코드 예제
public class PowerSet {

	public static void pick(boolean item[], boolean bucket[], int k, char element[]){
		if(k==0) {
			System.out.println("{");
			for(int i=0; i<bucket.length; i++) {
				if(bucket[i]) // true인 경우에 출력
					System.out.println(bucket[i] + " ");
			}
			System.out.println("}");
			return;
		}
		
		int lastIndex = bucket.length-k-1;
		
		// 
		for(int i=0; i<item.length; i++) {
			bucket[lastIndex+1] = item[i]; // 한 번은 포함 한 번은 미포함으로 계산하기
			pick(item, bucket, k-1, element);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean item[] = {true, false};
		char elements[] = {'a','b','c'}; // 집합
		boolean bucket[] = new boolean[elements.length];
		
		pick(item, bucket, bucket.length, elements);
		
	}

}
