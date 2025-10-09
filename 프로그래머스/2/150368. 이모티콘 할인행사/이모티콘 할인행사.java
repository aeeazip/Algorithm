import java.util.*;

class Solution {
    public static int[] picked; // 할인율 중복 순열
    public static int[] discount; // 할인율
    public static int r; // 뽑을 개수
    public static int[] answer; // 정답
    
    public int[] solution(int[][] users, int[] emoticons) {
        r = emoticons.length;
        discount = new int[]{ 10, 20, 30, 40 };
        picked = new int[r];
        
        answer = new int[]{ 0, 0 };
        dfs(0, users, emoticons);
        
        return answer;
    }
    
    public static void dfs(int depth, int[][] users, int[] emoticons) {
        if(depth == r) {
            int[] result = check(users, emoticons);
            if(result[0] > answer[0] || (result[0] == answer[0] && result[1] > answer[1])) {
                answer[0] = result[0]; 
                answer[1] = result[1];
            }
            return;
        }
        
        for(int i = 0; i < discount.length; i++) {
            picked[depth] = discount[i];
            dfs(depth + 1, users, emoticons);
        }
    }
    
    public static int[] check(int[][] users, int[] emoticons) {
        int[] costs = new int[users.length];
        boolean[] register = new boolean[users.length];
        int[] result = new int[2];
        
        for(int i = 0; i < picked.length; i++) {
            for(int j = 0; j < users.length; j++) {
                if(users[j][0] <= picked[i]) {
                    costs[j] += (emoticons[i] * (100 - picked[i]) * 0.01);
                }
            }
        }
        
        for(int i = 0; i < users.length; i++) {
            if(costs[i] < users[i][1]) {
                result[1] += costs[i];
                continue;
            }
            
            costs[i] = 0;
            register[i] = true;
            result[0]++;
        }
       
        return result;
    }
}