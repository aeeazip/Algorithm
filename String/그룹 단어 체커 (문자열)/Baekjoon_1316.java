package baekjoon;

import java.io.*;

public class Baekjoon_1316 {
    public static boolean solution(String str){
        boolean[] alpha = new boolean[26];
        
        for(int i=0; i<26; i++)
            alpha[i] = false;
            
        for(int i=0; i<str.length(); i++){
            int j = (int)str.charAt(i)-'a';
            
            if(!alpha[j])                               // 처음 나오는 경우
                alpha[j] = true;
            else if(str.charAt(i-1) == str.charAt(i))   // 직전과 같은 경우
                continue;
            else                                        // 이미 나온 알파벳 + 직전과 다른 경우 
                return false;
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());    // 단어의 개수
        int count = 0;
        
        for(int i=0; i<n; i++){
            if(solution(br.readLine()))
                count++;
        }
        
        System.out.println(count);
    }
}