import java.util.*;

class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        int n = message.length();
        boolean[] isSpoilerPos = new boolean[n];
        
        // 1. 스포일러 구간 기록
        for(int[] range : spoiler_ranges) {
            for(int i = range[0]; i <= range[1]; i++) isSpoilerPos[i] = true;
        }
        
        Set<String> notSpoilers = new HashSet<>(); // 스포일러가 아닌 단어
        List<String> spoilers = new ArrayList<>(); // 스포일러 단어
        
        // 2. 단어를 분류
        for(int i = 0; i < n; i++) {
            if(message.charAt(i) != ' ') {
                int start = i;
                boolean hasSpoiler = false;
                
                while(i < n && message.charAt(i) != ' ') {
                    if(isSpoilerPos[i]) hasSpoiler = true;
                    i++;
                }
                
                String word = message.substring(start, i);
                if(hasSpoiler) spoilers.add(word);
                else notSpoilers.add(word);
            }
        }
        
        // 3. 중요한 단어 개수 세기
        int answer = 0;
        
        for(String word : spoilers) {
            if(!notSpoilers.contains(word)) {
                answer++;
                notSpoilers.add(word);
            }
        }
        
        return answer;
        
    }
}