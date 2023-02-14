package baekjoon;

import java.util.*;

public class Baekjoon_2884 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m = sc.nextInt();
        
        if(m >= 45)
            System.out.println(h + " " + (m - 45));
        else{
            if(h == 0)
                System.out.println("23 " + (60 - (45 - m)));
            else
                System.out.println((h - 1) + " " + (60 - (45 - m)));
        }
    }
}