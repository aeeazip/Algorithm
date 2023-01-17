package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_10972 {

	public static void swap(Integer[] arr, int x, int y) {
		int temp = arr[x];
		arr[x]=arr[y];
		arr[y]=temp;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] s = br.readLine().split(" ");
		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++)
			arr[i]=Integer.parseInt(s[i]);

		Integer[] reverse = arr.clone();
		Arrays.sort(reverse, Collections.reverseOrder());

		if(Arrays.equals(arr, reverse))
			System.out.println("-1");
		else {
			int x =-1, y=-1;
			for(int i=n-1; i>=0; i--) {
				if(arr[i]>arr[i-1]) {
					x=i-1;
					y=i;
					break;
				}
			}

			for(int i=n-1; i>=0; i--) {
				if(arr[i]>arr[x]) {
					swap(arr, i, x);
					break;
				}
			}

			// 앞에서 인덱스 y부터 끝까지 오름차순 정렬
			Arrays.sort(arr, y, arr.length);
			for(int i=0; i<arr.length; i++)
				System.out.print(arr[i] + " ");
		}
	}

}
