package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_14425 {
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String[] num = br.readLine().split(" ");
		 int n = Integer.parseInt(num[0]);
		 int m = Integer.parseInt(num[1]);
		 
		 HashSet<String> set = new HashSet<String>();
		 for(int i=0; i<n; i++)
		    set.add(br.readLine());
		    
		int count = 0;    
		for(int i=0; i<m; i++){
		    String str = br.readLine();
		    if(set.contains(str))
		        count++;
		}
		
		System.out.println(count);
	}
}
