package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon_9934 {
	static int k;
	static int[] array;
	static StringBuffer[] newArray;

	static int a = 0;
	public static void inorderTree(int start, int end, int level) {
		if(level == k)
			return;
		
		int middle = (start+end)/2;
		newArray[level].append(array[middle] + " ");
		
		inorderTree(start, middle-1, level+1);
		inorderTree(middle+1, end, level+1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		k = Integer.parseInt(br.readLine());			// 완전 이진 트리의 높이
		array = new int[(int) (Math.pow(2, k)-1)];
		
		newArray = new StringBuffer[k];
		for(int i=0; i<k; i++)
			newArray[i] = new StringBuffer();
		
		String[] num = br.readLine().split(" ");
		for(int i=0; i<array.length; i++) 
			array[i] = Integer.parseInt(num[i]);

		inorderTree(0, array.length-1, 0);

		for(int i=0; i<k; i++)
			bw.write(newArray[i].toString() + "\n");
		bw.flush();
	}

}
