package baekjoon;

import java.util.*;

public class Baekjoon_2480 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = Math.max(Math.max(a, b), c);
        
        if(a==b && b==c)
            System.out.println(10000 + a * 1000);
        else if((a==b && b!=c) || (a==c && b!=c))
            System.out.println(1000 + a * 100);
        else if((c==b && a!=c))
            System.out.println(1000 + b * 100);
        else
            System.out.println(max*100);
    }
}