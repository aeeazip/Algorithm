import java.util.*;

public class Solution {
    public Stack<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            } else if(arr[i] != stack.peek()) {
                stack.push(arr[i]);
            }
        }
        
        return stack;
    }
}