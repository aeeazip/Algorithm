import java.util.*;
import java.awt.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder("");
        String[][] keypads = {
            {"1", "2", "3"}, 
            {"4", "5", "6"}, 
            {"7", "8", "9"}, 
            {"*", "0", "#"}
        };
        
        Point left = new Point(3, 0);
        Point right = new Point(3, 2);
        
        for(int n : numbers) {
            if(n == 1 || n == 4 || n == 7) {
                sb.append("L");
                left = new Point(n / 3, 0);
            } else if(n == 3 || n == 6 || n == 9) {
                sb.append("R");
                right = new Point(n / 3 - 1, 2);
            } else {
                // 2 -> 0 / 5 -> 1 / 8 -> 2 / 0 -> 4              
                int nowDx = n != 0 ? n / 4 : 3;
                int nowDy = 1;
                
                int leftDist = Math.abs(left.x - nowDx) + Math.abs(left.y - nowDy);
                int rightDist = Math.abs(right.x - nowDx) + Math.abs(right.y - nowDy);
                
                if(leftDist < rightDist || (hand.equals("left") && leftDist == rightDist)) {
                    sb.append("L");
                    left = new Point(nowDx, nowDy);                   
                } else if(leftDist > rightDist || (hand.equals("right") && leftDist == rightDist)) {
                    sb.append("R");
                    right = new Point(nowDx, nowDy);
                }
            } 
        }
        
        return sb.toString();
        
    }
}