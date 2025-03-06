import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                stack.push(arr[i]);
            } else if(arr[i] != stack.peek()) {
                stack.push(arr[i]);
            }
        }
        
        int i = stack.size() - 1;
        int[] answer = new int[stack.size()];
        while(!stack.isEmpty()) {
            answer[i--] = stack.pop();
        }
        
        return answer;
    }
}