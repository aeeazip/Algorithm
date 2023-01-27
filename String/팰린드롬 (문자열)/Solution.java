package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Baekjoon_8892 {

	public static String isPalindrome(String[] str, int x) {
		String newStr;
		
		for(int i=0; i<x; i++) {
			newStr = null;	
			for(int j=0; j<x; j++) {
				if(i == j)
					continue;
				
				newStr = str[i].concat(str[j]);
				
				boolean result = check(newStr);
				if(result)
					return newStr;
			}
		}
		return "0";
	}
	
	public static boolean check(String word) {
		int n = word.length();
        for (int i = 0; i < (n / 2); i++) {
            if (word.charAt(i) != word.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		int t = Integer.parseInt(br.readLine());			// 테스트 케이스 개수
		
		for(int i=0; i<t; i++) {
			int k = Integer.parseInt(br.readLine());		// 공책에 적힌 단어의 수
			
			String[] str = new String[k];					// 공책에 적힌 단어를 담는 배열
			
			for(int j=0; j<k; j++) {
				str[j] = br.readLine();
			}
			
			System.out.println(isPalindrome(str, k));	
		}
		
	}

}
