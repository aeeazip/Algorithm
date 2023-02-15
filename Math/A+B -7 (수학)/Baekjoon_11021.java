package baekjoon;

import java.io.*;

public class Baekjoon_11021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            String[] num = br.readLine().split(" ");
            int sum =  Integer.parseInt(num[0]) + Integer.parseInt(num[1]);
            System.out.println("Case #" + (i+1) + ": " + sum);
        }
    }
}