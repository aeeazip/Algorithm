import java.util.*;

class Solution {
    public static class Robot {
        int[] now; // 현재 좌표
        int[] goal; // 목적지 좌표
        int[] route; // 포인트 번호 배열
        int routeIndex; // 다음 목적지 인덱스
        boolean isArrived;
        
        public Robot(int x, int y, int[] route) {
            this.now = new int[]{ x, y };
            this.route = route;
            this.routeIndex = 1; // 첫 목표는 route[1];
            this.isArrived = false;
            this.goal = null;
        }    
        
        // 다음 목적지 좌표를 points에서 갱신
        public void updateGoal(int[][] points) {
            if(routeIndex < route.length) {
                int point = route[routeIndex];
                goal = new int[]{ points[point - 1][0], points[point - 1][1] };
            } else {
                isArrived = true;
                goal = null;
            }
        }
    }
    
    public int solution(int[][] points, int[][] routes) {
         // 1. 로봇 정보 저장
        Robot[] robots = new Robot[routes.length];
        for(int i = 0; i < routes.length; i++) {
            int startPoint = routes[i][0];
            int startX = points[startPoint - 1][0];
            int startY = points[startPoint - 1][1];
            robots[i] = new Robot(startX, startY, routes[i]);
            robots[i].updateGoal(points);
        }
        
        int count = 0; // 목적지에 도착한 로봇 갯수
        int result = 0; // 결과 저장용
        
        // 2. 0초일 때 충돌 체크
        Map<String, Integer> map = new HashMap<>(); // 특정 위치의 로봇 개수 저장용 
        for(Robot robot : robots) {
            String key = robot.now[0] + "," + robot.now[1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        for(String key : map.keySet()) {
            if(map.get(key) >= 2) result++;
        }
        
        // 3. 로봇 이동
        while(count != routes.length) {
            map.clear();
            
            // 4. 로봇 순서대로 1칸 옮기기
            for(int i = 0; i < robots.length; i++) {
                Robot robot = robots[i];
                
                if(robot.isArrived) continue;
                    
                // r을 c보다 먼저 이동
                if(robot.now[0] > robot.goal[0]) robot.now[0]--;
                else if(robot.now[0] < robot.goal[0]) robot.now[0]++;
                else if(robot.now[1] > robot.goal[1]) robot.now[1]--;
                else if(robot.now[1] < robot.goal[1]) robot.now[1]++;
                    
                // map 갱신
                String key = robot.now[0] + "," + robot.now[1];
                map.put(key, map.getOrDefault(key, 0) + 1);
                
                // 현재 목적지 도착 시 다음 목적지로
                if(robot.now[0] == robot.goal[0] && robot.now[1] == robot.goal[1]) {
                    robot.routeIndex++;
                    robot.updateGoal(points);
                    if(robot.isArrived) count++;
                }
            }
            
            // 5. 같은 좌표에 로봇이 2대 이상 모인 곳이 있는지 검사
            for(String key : map.keySet()) {
                if(map.get(key) >= 2) result++;
            }
        }
        
        return result;
    }
    
    
}