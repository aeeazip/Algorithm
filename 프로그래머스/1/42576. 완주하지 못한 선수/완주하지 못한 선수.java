import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, map.get(s) == null ? 1 : (map.get(s) + 1));
        }
        
        for(String s : participant) {
            if(map.get(s) != null) {
                if(map.get(s) != 1) {
                    map.put(s, map.get(s) - 1);
                } else { 
                    map.remove(s);
                }
            } else {
                return s;
            }
        }
        
        return "";
    }
}