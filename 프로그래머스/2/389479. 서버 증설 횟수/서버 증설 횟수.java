import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int count = 0; // 서버 증설 횟수 기록
        int[] time = new int[24]; // i시각에 증설된 서버의 개수
        Arrays.fill(time, 0);
        
        for(int i = 0; i < players.length; i++) {
            int player = players[i]; // i ~ i + 1 시각의 게임 이용자 수 
            int nServerCount = player / m; // 증설된 서버의 수
            int now = time[i]; // 현재 시각에 이미 증설되어 있는 서버 개수
            
            if(nServerCount < now || nServerCount < 1) continue;
            count += (nServerCount - now); // 증설 횟수
            
            // 증설된 서버 운영 시간 기록
            for(int j = i; j < i + k; j++) {
                if(j < 24) time[j] += (nServerCount - now);
            }
        }
        
        return count;
        
    }
}