package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1157 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.next();
        int[] count = new int[26];
        
        // a = 97 / A = 65
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            
            if(c>='A' && c<='Z')
                count[(int)c-'A']++;
            
            if(c>='a' && c<='z')
                count[(int)c-'a']++;
        }
        
        int max = 0, index = -1;
        for(int i=0; i<26; i++){
            if(max < count[i]){
                max = count[i];
                index = i;
            }
        }
        
        for(int i=index+1; i<26; i++){
            if(max == count[i]){
                index = -1;
                break;
            }
        }
        
        if(index == -1)
            System.out.println("?");
        else
            System.out.println((char) (index + 65));
        
    }
}