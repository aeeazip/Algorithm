import java.util.*;

class Solution {
    public static List<Integer> decimal = new ArrayList<>();
    public static int count = 0;
    
    public int solution(String numbers) {
        String[] nums = numbers.split("");
        
        for(int i = 1; i <= nums.length; i++) {
            int r = i; // 몇 개 뽑을지
            List<String> pick = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            permutation(nums, visited, pick, r);
        }
            
        
        return count;
    }
    
    public static void permutation(String[] nums, boolean[] visited, List<String> pick, int r) {
        for(int i = 0; i < nums.length; i++) {
            if(pick.size() == r) { // r개 뽑음
                String num = "";

                for(String n : pick) {
                    num += n;

                    if(!decimal.contains(Integer.parseInt(num))) {
                        if(isDecimal(Integer.parseInt(num))) {
                            count++;
                            decimal.add(Integer.parseInt(num));
                        }
                    }
                }

                return;
            }

            if(visited[i]) continue;

            visited[i] = true;
            pick.add(nums[i]);
            permutation(nums, visited, pick, r);

            visited[i] = false;
            pick.remove(pick.size() - 1);
        }

    }
    
    public static boolean isDecimal(int n) {
        if(n == 0 || n == 1) return false;
        
        for(int i = 2; i < n; i++) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
}