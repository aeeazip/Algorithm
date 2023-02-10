package baekjoon;

import java.io.*;

public class Baekjoon_1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        
        System.out.println(Double.parseDouble(num[0]) / Double.parseDouble(num[1]));
    }
}