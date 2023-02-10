package baekjoon;

import java.io.*;

public class Baekjoon_3003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        
        System.out.print(1 - Integer.parseInt(num[0]) + " ");
        System.out.print(1 - Integer.parseInt(num[1]) + " ");
        System.out.print(2 - Integer.parseInt(num[2]) + " ");
        System.out.print(2 - Integer.parseInt(num[3]) + " ");
        System.out.print(2 - Integer.parseInt(num[4]) + " ");
        System.out.print(8 - Integer.parseInt(num[5]));
    }
}