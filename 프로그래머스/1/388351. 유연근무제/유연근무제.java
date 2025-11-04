class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i = 0; i < schedules.length; i++) {
            int day = startday;
            int count = 0;
            
            int hour = schedules[i] / 100;
            int time = schedules[i] % 100;
            
            for(int j = 0; j < timelogs[0].length; j++) {
                if(day % 7 == 6 || day % 7 == 0) {
                    count++;          
                } else {
                    int temp = time + 10 >= 60 ? (hour + 1) * 100 + time - 50 : hour * 100 + time + 10; 
                    if(timelogs[i][j] <= temp) count++;              
                }
                
                day++;
            }
            
            if(count == timelogs[0].length) answer++;
        }
        
        return answer;
    };
}