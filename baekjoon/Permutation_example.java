package baekjoon;

public class Permutation_example {
	/*
	static void perm(char data[], int k) {
		int n = data.length;
		
		if(k==n) {
			for(int i=0; i<n; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		
		for(int i=k; i<n; i++) {
			swap(data, k, i);
			perm(data, k+1);
			swap(data, k, i);
		}
		
		return;
	}
	
	static void swap(char data[], int k, int i) {
		char temp = data[k];	
		data[k] = data[i];
		data[i] = temp;
	}
	*/
	
	static void solution(char item[], char bucket[], int k) {
		int i, j, lastIndex;
		
		if(k == 0) {
			for(i=0; i<bucket.length; i++) {
				System.out.print(bucket[i] + " ");
			}
			System.out.println();
		}
		
		lastIndex = bucket.length-k-1;
		
		for(i=0; i<item.length; i++) {
			int flag=0;
			for(j=0; j<=lastIndex; j++) {
				if(item[i] == bucket[j]) {
					flag = 1;
					break;
				}
			}
			
			if(flag == 0) {
				bucket[lastIndex+1] = item[i];
				solution(item, bucket, k-1);
			}					
		}
	}
	
	public static void main(String[] args) {
		// 진짜 아이템을 뽑는 것과 인덱스를 뽑는 것과 동일하다
		// 인덱스를 뽑으면 실제로 출력할 때 인덱스에 해당하는 값을 출력하기
		
		
		char[] item = {'a', 'b', 'c'};
		char[] bucket = new char[item.length];
		solution(item, bucket, item.length);
		
		
		/*
		char[] data = {'a','b','c','d'};
		perm(data, 0);
		*/
	}

}
