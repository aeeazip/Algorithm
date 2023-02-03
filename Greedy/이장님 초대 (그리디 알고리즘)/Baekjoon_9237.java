package baekjoon; 
  
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_9237 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();		// 묘묙의 수		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++)
			list.add(sc.nextInt());
			
		Collections.sort(list, Collections.reverseOrder());
		
		int sum = list.get(0);
		
		for(int i=1; i<n; i++) {
			int diff = (i+list.get(i)-sum);
			if(diff > 0)
				sum += diff;
		}
		
		System.out.println(sum+2);
	}

}
