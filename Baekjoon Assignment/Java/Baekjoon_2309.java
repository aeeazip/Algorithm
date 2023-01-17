package baekjoon;

import java.util.*;

public class Baekjoon_2309 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] item = new int[9];
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<item.length; i++) {
			item[i] = sc.nextInt();
			sum += item[i];
		}
		Arrays.sort(item);
		
		int x=0, y=0;
		for(int i=0; i<item.length-1; i++) {
			for(int j=i+1; j<item.length; j++) {
				if(sum-item[i]-item[j]==100) {
					x=i;
					y=j;
					break;
				}
			}
		}
		
		for(int i=0; i<item.length; i++) {
			if(i==x || i==y)
				continue;
			System.out.println(item[i]);
		}
		
		/*
		for(int i=0; i<item.length; i++) {
			if(i==x || i==y)
				System.out.print("");
			else
				System.out.println(item[i]);
		}
		return;
		*/
	}

}
