package baekjoon;

import java.util.*;

public class Baekjoon_2588 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();    // (1) 값 입력받기
        int b = sc.nextInt();    // (2) 값 입력받기
        
        System.out.println(a * (b % 10));
        System.out.println(a * (b % 100 / 10));
        System.out.println(a * (b / 100));
        System.out.println(a * b);
    }
}