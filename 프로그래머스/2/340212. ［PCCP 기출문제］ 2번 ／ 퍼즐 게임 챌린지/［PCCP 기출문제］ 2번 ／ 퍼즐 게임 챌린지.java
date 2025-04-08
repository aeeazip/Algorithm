import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();
        int min = Integer.MAX_VALUE;
        
        while(start <= end) {
            int mid = (start + end) / 2;
            long count = 0; // 소요시간
            
            for(int i = 0; i < diffs.length; i++) {
                if(diffs[i] <= mid) {
                    count += times[i];
                } else {
                    int wrongCount = diffs[i] - mid;
                    int time = (times[i] + times[i - 1]) * wrongCount + times[i];
                    count += time;
                }
            }
         
            if(count <= limit) {
                min = Math.min(min, mid); // mid 작게
                end = mid - 1;
            } else if(count > limit) {
                start = mid + 1;
            }
            
        }
        
        return min;
    }
}