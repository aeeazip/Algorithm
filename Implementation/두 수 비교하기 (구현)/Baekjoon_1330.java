package baekjoon;

import java.io.*;

public class Baekjoon_1330 {
    public static void main(String[] args) throws IOException {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String[] num = br.readLine().split(" ");
        
           int a = Integer.parseInt(num[0]);
           int b = Integer.parseInt(num[1]);
        
           if(a > b)
               System.out.println(">");
           else if(a < b)
               System.out.println("<");
           else
               System.out.println("==");    
    }
}