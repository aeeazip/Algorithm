import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>(); // 의상 종류, 개수
        for(int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.get(key) == null ? 1 : map.get(key) + 1);
        }
        
        // 각 의상 종류별 개수 + 1을 곱함 (입지 않는 경우 포함)
        int result = 1;
        for(String key : map.keySet()) {
            result *= (map.get(key) + 1);
        }
        
        // 모든 의상을 입지 않는 경우는 제외
        return result - 1;
    }
    
    
}