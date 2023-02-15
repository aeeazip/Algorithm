package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_4344 {
    public static void solution(String[] num){
        double sum = 0;
        double count = 0;
        
        for(int i=1; i<num.length; i++){
            sum += Double.parseDouble(num[i]);
        }
        
        for(int i=1; i<num.length; i++){
            if(Double.parseDouble(num[i]) > sum/(num.length-1))
                count++;
        }
    
        System.out.printf("%.3f%%\n",(count/(num.length-1))*100);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            String[] num = br.readLine().split(" ");
            solution(num);  
        }
    }
}