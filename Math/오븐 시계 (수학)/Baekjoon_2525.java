package baekjoon;

import java.util.*;

public class Baekjoon_2525 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int h = sc.nextInt();
        int m = sc.nextInt();
        int need = sc.nextInt();
        
        h = (h + ((m+need)/60)) % 24;
        m = (m+need) % 60;
        
        System.out.println(h + " " + m);
    }
}