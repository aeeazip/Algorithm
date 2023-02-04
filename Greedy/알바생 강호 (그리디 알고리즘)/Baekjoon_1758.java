package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Baekjoon_1758 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++)
			list.add(sc.nextInt());
		
		Collections.sort(list, Collections.reverseOrder());
		
		long sum = 0;
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)-i > 0)
				sum += list.get(i)-i;
			else
				break;
		}
		
		System.out.println(sum);
	}

}
