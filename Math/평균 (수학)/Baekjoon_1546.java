package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double [] arr = new double[n];
        String[] num  = br.readLine().split(" ");
        
        for(int i=0; i<n; i++)
            arr[i] = Double.parseDouble(num[i]);
        
        Arrays.sort(arr);
        
        double M = arr[n-1];
        double sum = 0;
        
        for(int i=0; i<n; i++)
            sum += (arr[i]*100/M);
        
        System.out.println(sum/n);       
    }
}