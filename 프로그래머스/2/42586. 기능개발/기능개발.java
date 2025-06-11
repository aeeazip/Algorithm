import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++) {
            queue.add(new int[]{ progresses[i], speeds[i] });
        }
        
        int[] answer = new int[speeds.length];
        int index = -1; // answer 삽입용 인덱스
        int last = 0; // 직전 작업이 며칠 걸리는지 기록
        
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int todo = 100 - info[0];
            int days = todo / info[1];
            
            if(todo % info[1] != 0) {
                days++;
            }
            
            if(days <= last) {
                answer[index]++;
            } else {
                index++;
                last = days;
                answer[index] = 1;
            }    
        }
        
        return Arrays.stream(answer).filter(num -> num != 0).toArray();
    }
}