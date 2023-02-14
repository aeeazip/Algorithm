package baekjoon;

import java.util.*;

public class Baekjoon_1110 {
    static int n;
    
    public static int solution(int x, int y){    // x는 십의 자리, y는 일의 자리
        if(x == n/10 && y == n%10)
            return 1;
        else
            return 1 + solution(y, (x+y)%10);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        if(n < 10)
            System.out.println(solution(n, n));
        else
            System.out.println(solution(n%10, (n/10 + n%10)%10));
    }
}