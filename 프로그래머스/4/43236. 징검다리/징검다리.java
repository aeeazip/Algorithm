import java.util.*;

class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        int left = 1;
        int right = distance;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;  // 현재 최소 거리 후보
            int removed = 0;
            int lastPosition = 0;  // 기준이 되는 바위 위치

            for (int rock : rocks) {
                if (rock - lastPosition < mid) {
                    // mid보다 작은 거리면 바위 제거
                    removed++;
                } else {
                    lastPosition = rock;
                }
            }

            if (distance - lastPosition < mid) {
                // 마지막 바위와 도착점 사이의 거리도 확인
                removed++;
            }

            if (removed <= n) {
                answer = mid;  // 최적의 거리 갱신
                left = mid + 1;  // 더 큰 최소 거리 탐색
            } else {
                right = mid - 1;  // mid 값을 줄여야 함
            }
        }

        return answer;
    }
}