package baekjoon;

import java.util.*;
import java.io.*;

public class Baekjoon_4948 {
    public static int solution(int n){
        int count = 0;
        int[] arr = new int[2*n+1];  
        
        for(int i=2; i<=2*n; i++)
            arr[i] = i;
        
        for(int i=2; i*i<=2*n; i++){
            if(arr[i]==0)
                continue;
            
            for(int j=i*2; j<=2*n; j+=i)
                arr[j] = 0;
        }
        
        for(int i=n+1; i<=2*n; i++)
            if(arr[i] != 0)
                count++;
        
        return count;
    }
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while(true){
            int n = sc.nextInt();
            if(n==0)
                break;
            
            bw.write(solution(n) + "\n");
        }
        
        bw.flush();
        bw.close();
       
    }
}