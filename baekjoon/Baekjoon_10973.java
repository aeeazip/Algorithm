package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

// TestCase 1 : 5 4 3 2 1 -> 5 4 3 1 2
// TestCase 2 : 5 1 2 3 4 -> 4 5 3 2 1
// TestCase 3 : 5 8 6 7 9 -> 5 7 9 8 6

// 알고리즘
// 뒤에서부터 n이 n-1보다 작은 구간 체크
// x=n-1 / y=n 뒤에서부터 x보다 작은값 나오면 swap하고 변경
// y 범위부터 내림차순 정렬

public class Baekjoon_10973 {

	public static void swap(Integer[] arr, int x, int y) {
		int temp=arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];

		String[] str = br.readLine().split(" ");
		for(int i=0; i<n; i++)
			arr[i]=Integer.parseInt(str[i]);

		Integer[] clone = arr.clone();
		Arrays.sort(clone);

		if(Arrays.equals(clone, arr))
			System.out.println("-1");
		else {
			int x=-1, y=-1;

			for(int i=arr.length-1; i>=0; i--) {
				if(arr[i]<arr[i-1]) {
					x=i-1;
					y=i;
					break;
				}
			}

			for(int i=arr.length-1; i>=0; i--) {
				if(arr[i]<arr[x]) {
					swap(arr, i, x);
					break;
				}
			}

			Arrays.sort(arr, y, arr.length, Collections.reverseOrder());
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i] + " ");
		}


	}

}
