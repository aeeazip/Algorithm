package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_2581 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[] arr = new int[n+1];
		
		int min = 0, sum = 0;
		for(int i=2; i<=n; i++)
		    arr[i] = i;
		    
		for(int i=2; i<=n; i++){
		    if(arr[i]==0)
		        continue;
		    
		    for(int j=2*i; j<=n; j+=i)
		        arr[j] = 0;
		}

		for(int i=m; i<=n; i++){
		    if(arr[i]!=0 && min==0)
		        min=arr[i];
		    
		    if(arr[i]!=0)
		        sum+=arr[i];
		}
		
		if(sum == 0)
		    System.out.println("-1");
		else
		    System.out.println(sum + "\n" + min);
	}
}
