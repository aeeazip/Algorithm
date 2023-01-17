package baekjoon;

public class Permutation {

	public static void solution(char item[], char bucket[], int k) {
		if(k==0) {
			System.out.println("{");
			for(int i=0; i<bucket.length; i++) {
					System.out.println(bucket[i] + " ");
			}
			System.out.println("}");
			return;
		}
		
		int lastIndex = bucket.length-k-1;
		for(int i=0; i<item.length; i++) {
			int flag=0;
			
			for(int j=0; j<=lastIndex; j++) {
				if(item[i]==bucket[j]) {
					flag=1;
					break;
				}
			}
			
			if(flag==1) continue;
			bucket[lastIndex+1] = item[i];
			solution(item, bucket, k-1);
		}
	}
	public static void main(String[] args) {
		// 진짜 아이템을 뽑는 것과 인덱스를 뽑는 것과 동일하다
		// 인덱스를 뽑으면 실제로 출력할 때 인덱스에 해당하는 값을 출력하기
		
		char[] item = {'a', 'b', 'c'};
		char[] bucket = new char[item.length];
		solution(item, bucket, item.length);
	}

}
