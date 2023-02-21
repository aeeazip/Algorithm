package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_1065 {
    public static boolean solution(int n){
        int[] arr = new int[4];
        arr[0] = n / 1000;
        arr[1] = (n % 1000) / 100;
        arr[2] = (n % 1000) % 100 / 10;
        arr[3] = (n % 1000) % 100 % 10;
        
        // 등차수열 판별
        if(arr[0]==0 && arr[1]==0) //한 자리 정수 or 두 자리 정수는 항상 한수
            return true;
        else if(arr[0]==0 && arr[1]!=0) // 세 자리 정수   
            if(arr[1]-arr[2] == arr[2]-arr[3])
                return true;
        return false;   // 1000 or 세 자리 정수이지만 한수가 아닌 경우
    }
    
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int count = 0;
		for(int i=1; i<=n; i++){
		    if(solution(i))
		        count++;
		}
		
		System.out.println(count);
	}
}
