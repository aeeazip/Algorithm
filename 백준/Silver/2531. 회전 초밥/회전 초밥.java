import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 접시 수
        int d = sc.nextInt(); // 초밥 가짓수
        int k = sc.nextInt(); // 연속해서 먹는 접시 수
        int c = sc.nextInt(); // 쿠폰 번호
        
        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = sc.nextInt();
        }
        sc.close();
        
        Map<Integer, Integer> sushiMap = new HashMap<>();
        int uniqueCount = 0;
        
        // 초기 윈도우 설정 (0~k-1)
        for (int i = 0; i < k; i++) {
            sushiMap.put(belt[i], sushiMap.getOrDefault(belt[i], 0) + 1);
        }
        uniqueCount = sushiMap.size();
        
        // 슬라이딩 윈도우
        int maxCount = uniqueCount;
        for (int i = 0; i < N; i++) {
            int removeIdx = i; // 제거할 초밥
            int addIdx = (i + k) % N; // 추가할 초밥 (회전 고려)
            
            // 기존 초밥 제거
            sushiMap.put(belt[removeIdx], sushiMap.get(belt[removeIdx]) - 1);
            if (sushiMap.get(belt[removeIdx]) == 0) {
                sushiMap.remove(belt[removeIdx]);
                uniqueCount--;
            }
            
            // 새로운 초밥 추가
            sushiMap.put(belt[addIdx], sushiMap.getOrDefault(belt[addIdx], 0) + 1);
            if (sushiMap.get(belt[addIdx]) == 1) {
                uniqueCount++;
            }
            
            // 쿠폰 초밥 추가 고려
            int currentMax = sushiMap.containsKey(c) ? uniqueCount : uniqueCount + 1;
            maxCount = Math.max(maxCount, currentMax);
        }
        
        System.out.println(maxCount);
    }
}
