package baekjoon;

import java.util.*;
import java.io.*;


public class Baekjoon_10950 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = sc.nextInt();
        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            bw.write(a+b+"\n");
        }
        
        bw.flush();
        bw.close();
    }
}