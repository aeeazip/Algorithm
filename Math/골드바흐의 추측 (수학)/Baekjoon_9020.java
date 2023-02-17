package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_9020 {
    public static void solution(int x){
        int[] arr = new int[x+1];
        
        for(int i=2; i<=x; i++)
            arr[i] = i;
            
        for(int i=2; i<=x; i++){
            if(arr[i] == 0)
                continue;
            
            for(int j=i*2; j<=x; j+=i)
                arr[j] = 0;
        }
        
        for(int i=x/2; i>=2; i--){
            if(arr[i]!=0 && arr[x-i]!=0){
                System.out.println(arr[i] + " " + arr[x-i]);
                break;
            }
        }
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++){
		  int x = sc.nextInt();
		  solution(x);
		}
	}
}
