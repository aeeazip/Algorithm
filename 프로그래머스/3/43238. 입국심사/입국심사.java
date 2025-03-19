import java.util.*;

class Solution {
    public static long solution(int n, int[] times) {
        Arrays.sort(times); // 정렬

        long left = 1;
        long right = (long) times[times.length - 1] * n; // 최대로 걸리는 시간
        long result = right;

        while(left <= right) {
            long count = 0;
            long mid = (left + right) / 2;

            for(int i = 0; i < times.length; i++) {
                count += (mid / times[i]); // 심사대에서 mid초 동안 심사할 수 있는 인원
            }

            if(count >= n) {
                result = mid;
                right = mid - 1;
            }
            else if(count < n) {
                left = mid + 1;
            }
        }

        return result;
    }
}