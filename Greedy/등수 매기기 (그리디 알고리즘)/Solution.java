package baekjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_2012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] array = new int[N];				// 예상 등수 저장하는 배열
		long sum = 0;							// 불만도의 합
		
		for(int i=0; i<N; i++)					// 예상 등수 입력받기
			array[i] = sc.nextInt();
		
		Arrays.sort(array);						// 입력받은 예상 등수 오름차순 정렬하기
		
		for(int i=0; i<N; i++) {
			sum += Math.abs(array[i] - (i+1));
		}
		
		sc.close();
		System.out.println(sum);
	}

}
